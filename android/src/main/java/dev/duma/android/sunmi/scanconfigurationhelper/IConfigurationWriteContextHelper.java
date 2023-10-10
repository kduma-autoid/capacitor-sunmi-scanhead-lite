package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;

public interface IConfigurationWriteContextHelper {
    interface IContextCreated {
        void onCreated(ServiceConfiguration configuration) throws RemoteException;
    }

    void createWriteContext(IContextCreated callback) throws RemoteException;
    void commitWriteContext() throws RemoteException;
    void discardWriteContext();
    boolean hasWriteContext();
    ServiceConfiguration getWriteContext();

    class Factory
    {
        static public IConfigurationWriteContextHelper make(IScanConfigurationHelper scanConfigurationHelper) {
            return new ConfigurationWriteContextHelper(scanConfigurationHelper);
        }
    }
}
