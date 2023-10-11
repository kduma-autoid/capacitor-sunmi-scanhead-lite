package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;
import android.util.Log;

import com.sunmi.scanner.config.SunmiHelper;
import com.sunmi.scanner.entity.CodeEnable;
import com.sunmi.scanner.entity.CodeSetting;
import com.sunmi.scanner.entity.Entity;
import com.sunmi.scanner.entity.Pair;
import com.sunmi.scanner.entity.Result;
import com.sunmi.scanner.entity.ServiceSetting;

import java.util.ArrayList;
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
            setting.scanExpSwitch = scanExpSwitch.get();
            setting.specificScene = specificScene.get();
            callback.onLoaded(
                    ServiceConfigurationConverter.fromServiceSetting(
                            setting,
                            advancedFormat.get()
                    )
            );
        };

        IQueryCallback<Result> specificSceneCallback = (response, entity) -> {
            try {
                String value = response.result.substring(response.result.lastIndexOf("=") + 1);
                specificScene.set(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                specificScene.set(-1);
            }
            scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, advancedFormatCallback);
        };

        IQueryCallback<Result> scanExpSwitchCallback = (response, entity) -> {
            try {
                String value = response.result.substring(response.result.lastIndexOf("=") + 1);
                scanExpSwitch.set(Integer.valueOf(value));
            } catch (NumberFormatException e) {
                scanExpSwitch.set(-1);
            }
            scanInterfaceHelper.sendQuery(SunmiHelper.SET_SCAN_SPECIFIC_SCENE, specificSceneCallback);
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

            CodeFamiliesConfiguration configuration = CodeFamiliesConfigurationConverter.fromCodeEnable(
                    codeEnabled.get()
            );

            for (String name: response.codes) {
                scanInterfaceHelper.sendQuery(SunmiHelper.queryCodeSetting(name), (CodeSetting r, Entity<CodeSetting> e) -> {
                    CodeFamiliesConfigurationConverter.setCodeSetting(configuration, name, r);
                    Log.i(name, r.toString());
                });
            }
            callback.onLoaded(
                    configuration
            );
        };

        scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_ENABLE_CODE, codeEnabledCallback);
    }

    @Override
    public void persistCodeFamiliesConfig(CodeFamiliesConfiguration configuration) throws RemoteException {

    }
}