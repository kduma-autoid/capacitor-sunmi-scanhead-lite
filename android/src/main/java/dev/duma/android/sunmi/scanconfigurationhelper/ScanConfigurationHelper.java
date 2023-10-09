package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;
import android.util.Log;

import com.sunmi.scanner.config.SunmiHelper;
import com.sunmi.scanner.entity.Pair;
import com.sunmi.scanner.entity.ServiceSetting;

import java.util.ArrayList;

import dev.duma.android.sunmi.scanconfigurationhelper.models.ServiceConfiguration;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper.IQueryCallback;

public class ScanConfigurationHelper implements IScanConfigurationHelper {
    private final IScanInterfaceHelper scanInterfaceHelper;

    public ScanConfigurationHelper(IScanInterfaceHelper scanInterfaceHelper) {
        this.scanInterfaceHelper = scanInterfaceHelper;
    }

    @Override
    public void loadServiceConfig(IServiceConfigLoadedCallback callback) throws RemoteException {
        scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_SETTING_INFO, (IQueryCallback<ServiceSetting>) (response, entity) -> {
            scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, (IQueryCallback<ArrayList<Pair>>) (response_format, entity_format) -> {
                callback.onLoaded(
                        ServiceConfiguration.fromServiceSetting(response, response_format), response
                );
            });
        });
    }

    @Override
    public void persistServiceConfig(ServiceConfiguration configuration, ServiceSetting original) throws RemoteException {
        ServiceSetting serviceSetting = configuration.toServiceSetting(original);
        String command = SunmiHelper.convertCmd(serviceSetting);
        command += SunmiHelper.setScanTrigger(serviceSetting.mTrigger);
        command += SunmiHelper.setTriggerOverTime(configuration.getTriggerOverTime());
        Log.i("CMD", command);
        scanInterfaceHelper.sendCommand(command);
    }
}

//scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_ENABLE_CODE, (IScanInterfaceHelper.IQueryCallback<CodeEnable>) (response, entity) -> {
//Log.i("QUERY_ALL_ENABLE_CODE", "response="+response.toString());
//});
//scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, (IScanInterfaceHelper.IQueryCallback<ArrayList<Pair>>) (response, entity) -> {
//Log.i("QUERY_ADVANCED_FORMAT", "response="+response.toString());
//});