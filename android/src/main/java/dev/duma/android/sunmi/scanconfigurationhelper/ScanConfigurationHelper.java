package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;

import com.sunmi.scanner.config.SunmiHelper;
import com.sunmi.scanner.constants.CodeConstants;
import com.sunmi.scanner.entity.CodeEnable;
import com.sunmi.scanner.entity.CodeSetting;
import com.sunmi.scanner.entity.Entity;
import com.sunmi.scanner.entity.Pair;
import com.sunmi.scanner.entity.Result;
import com.sunmi.scanner.entity.ServiceSetting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

import dev.duma.android.sunmi.scanconfigurationhelper.config.CodeFamiliesConfigurationConverter;
import dev.duma.android.sunmi.scanconfigurationhelper.config.CodeFamiliesConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfigurationConverter;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper.IQueryCallback;

public class ScanConfigurationHelper implements IScanConfigurationHelper {
    private final IScanInterfaceHelper scanInterfaceHelper;

    public ScanConfigurationHelper(IScanInterfaceHelper scanInterfaceHelper) {
        this.scanInterfaceHelper = scanInterfaceHelper;
    }

    @Override
    public void loadServiceConfig(IServiceConfigLoadedCallback<ServiceConfiguration> callback) throws RemoteException {
        AtomicReference<ServiceSetting> serviceSetting = new AtomicReference<>();
        AtomicReference<ArrayList<Pair>> advancedFormat = new AtomicReference<>();

        AtomicReference<Integer> scanExpSwitch = new AtomicReference<>();
        AtomicReference<Integer> specificScene = new AtomicReference<>();

        IQueryCallback<ArrayList<Pair>> advancedFormatCallback = (response, entity) -> {
            advancedFormat.set(response);

            ServiceSetting setting = serviceSetting.get();
//            setting.scanExpSwitch = scanExpSwitch.get();
//            setting.specificScene = specificScene.get();
            callback.onLoaded(
                    ServiceConfigurationConverter.fromServiceSetting(
                            setting,
                            advancedFormat.get()
                    )
            );
        };

        IQueryCallback<Result> specificSceneCallback = new IQueryCallback<Result>() {
            @Override
            public void onSuccess(Result response, Entity<Result> entity) throws RemoteException {
                try {
                    String value = response.getResult().substring(response.getResult().lastIndexOf("=") + 1);
                    specificScene.set(Integer.valueOf(value));
                } catch (NumberFormatException e) {
                    specificScene.set(-1);
                }
                scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, advancedFormatCallback);
            }

            @Override
            public void onFailed(int i) {
                specificScene.set(-1);
                try {
                    scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, advancedFormatCallback);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        IQueryCallback<Result> scanExpSwitchCallback = new IQueryCallback<Result>() {
            @Override
            public void onSuccess(Result response, Entity<Result> entity) throws RemoteException {
                try {
                    String value = response.getResult().substring(response.getResult().lastIndexOf("=") + 1);
                    scanExpSwitch.set(Integer.valueOf(value));
                } catch (NumberFormatException e) {
                    scanExpSwitch.set(-1);
                }
                scanInterfaceHelper.sendQuery(SunmiHelper.SET_SCAN_SPECIFIC_SCENE, specificSceneCallback);
            }

            @Override
            public void onFailed(int i) {
                scanExpSwitch.set(-1);
                try {
                    scanInterfaceHelper.sendQuery(SunmiHelper.SET_SCAN_SPECIFIC_SCENE, specificSceneCallback);
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        IQueryCallback<ServiceSetting> serviceSettingsCallback = (response, entity) -> {
            serviceSetting.set(response);
            scanInterfaceHelper.sendQuery(SunmiHelper.SET_FLASH_CONTROL, scanExpSwitchCallback);
        };

        scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_SETTING_INFO, serviceSettingsCallback);
    }

    @Override
    public void persistServiceConfig(ServiceConfiguration configuration) throws RemoteException {
        ArrayList<String> configurationCommands = ServiceConfigurationConverter.toConfigurationCommands(configuration);
        Log.i("CMD", configurationCommands.toString());
        for (String command: configurationCommands) {
            scanInterfaceHelper.sendCommand(command);
        }
    }

    @Override
    public void loadCodeFamiliesConfig(IServiceConfigLoadedCallback<CodeFamiliesConfiguration> callback) throws RemoteException {
        AtomicReference<CodeEnable> codeEnabled = new AtomicReference<>();

        IQueryCallback<CodeEnable> codeEnabledCallback = (response, entity) -> {
            codeEnabled.set(response);

            AtomicReference<ArrayMap<String, CodeSetting>> settings = new AtomicReference<>(new ArrayMap<>(response.getCodes().length));
            AtomicReference<ArrayList<String>> toGet = new AtomicReference<>(new ArrayList<>(Arrays.asList(response.getCodes())));
            toGet.get().add(0, CodeConstants.C_1D_BARCODE);

            AtomicReference<String> currentName = new AtomicReference<>("");
            var ref = new Object() {
                IQueryCallback<CodeSetting> codeSettingIQueryCallback = null;
            };

            Runnable runnable = () -> {
                while (!toGet.get().isEmpty()) {
                    currentName.set(toGet.get().remove(0));
                    String command = SunmiHelper.queryCodeSetting(currentName.get());
                    if (command != null && !command.equals("")) {
                        try {
                            scanInterfaceHelper.sendQuery(command, ref.codeSettingIQueryCallback);
                            return;
                        } catch (RemoteException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Log.e("CodeSetting", "Command not found for="+ currentName.get());
                    }
                }

                Log.e("CodeSetting", "Done="+ settings);
                try {
                    callback.onLoaded(
                            CodeFamiliesConfigurationConverter.fromCodeEnable(
                                    codeEnabled.get(),
                                    settings.get()
                            )
                    );
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            };

            ref.codeSettingIQueryCallback = new IQueryCallback<>() {
                @Override
                public void onSuccess(CodeSetting r, Entity<CodeSetting> e) throws RemoteException {
                    settings.get().put(currentName.get(), r);
                    Log.i(currentName.get(), r.toString());
                    runnable.run();
                }

                @Override
                public void onFailed(int i) {
                    Log.e(currentName.get(), "Failed to get");
                    runnable.run();
                }
            };

            runnable.run();
        };

        scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_ENABLE_CODE, codeEnabledCallback);
    }

    @Override
    public void persistCodeFamiliesConfig(CodeFamiliesConfiguration configuration) throws RemoteException {
        ArrayList<String> configurationCommands = CodeFamiliesConfigurationConverter.toConfigurationCommands(configuration);
        Log.i("CMD", configurationCommands.toString());
        for (String command: configurationCommands) {
            scanInterfaceHelper.sendCommand(command);
        }
    }
}