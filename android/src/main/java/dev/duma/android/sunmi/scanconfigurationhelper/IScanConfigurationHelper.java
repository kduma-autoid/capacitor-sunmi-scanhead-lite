package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;

public interface IScanConfigurationHelper {
    interface IServiceConfigLoadedCallback {
        void onLoaded(ServiceConfiguration configuration) throws RemoteException;
    }

    void loadServiceConfig(IServiceConfigLoadedCallback callback) throws RemoteException;
    void persistServiceConfig(ServiceConfiguration configuration) throws RemoteException;

    class Factory
    {
        static public IScanConfigurationHelper make(IScanInterfaceHelper scanInterfaceHelper) {
            return new ScanConfigurationHelper(scanInterfaceHelper);
        }
    }
}
