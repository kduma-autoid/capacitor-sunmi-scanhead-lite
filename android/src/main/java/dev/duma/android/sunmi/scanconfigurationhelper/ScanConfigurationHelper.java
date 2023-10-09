package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;
import android.util.Log;

import com.sunmi.scanner.entity.ServiceSetting;

import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.capacitor.sunmiscanhead.SunmiHelper;

public class ScanConfigurationHelper implements IScanConfigurationHelper {
    private final IScanInterfaceHelper scanInterfaceHelper;

    public ScanConfigurationHelper(IScanInterfaceHelper scanInterfaceHelper) {
        this.scanInterfaceHelper = scanInterfaceHelper;
    }

    @Override
    public void loadConfig() throws RemoteException {
        //        getScanInterfaceHelper().sendQuery(SunmiHelper.QUERY_ALL_ENABLE_CODE, (IScanInterfaceHelper.IQueryCallback<CodeEnable>) (response, entity) -> {
//            Log.i("QUERY_ALL_ENABLE_CODE", "response="+response.toString());
//        });
//        getScanInterfaceHelper().sendQuery(SunmiHelper.QUERY_ADVANCED_FORMAT, (IScanInterfaceHelper.IQueryCallback<ArrayList>) (response, entity) -> {
//            Log.i("QUERY_ADVANCED_FORMAT", "response="+response.toString());
//        });
        scanInterfaceHelper.sendQuery(SunmiHelper.QUERY_ALL_SETTING_INFO, (IScanInterfaceHelper.IQueryCallback<ServiceSetting>) (response, entity) -> {
            Log.i("QUERY_ALL_SETTING_INFO", "response="+response.toString());
        });
    }
}
