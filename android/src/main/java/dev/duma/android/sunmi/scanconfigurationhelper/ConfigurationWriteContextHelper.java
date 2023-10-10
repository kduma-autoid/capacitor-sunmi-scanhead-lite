package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;

public class ConfigurationWriteContextHelper implements IConfigurationWriteContextHelper {
    private final IScanConfigurationHelper scanConfigurationHelper;

    private ServiceConfiguration writeContext;

    public ConfigurationWriteContextHelper(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    @Override
    public void createWriteContext(IContextCreated callback) throws RemoteException {
        if(hasWriteContext()) discardWriteContext();

        scanConfigurationHelper.loadServiceConfig(configuration -> {
            this.writeContext = configuration;

            callback.onCreated(configuration);
        });
    }

    @Override
    public void commitWriteContext() throws RemoteException {
        if(!hasWriteContext()) throw new RuntimeException("No opened write context has been found!");

        scanConfigurationHelper.persistServiceConfig(this.writeContext);

        discardWriteContext();
    }

    @Override
    public void discardWriteContext() {
        this.writeContext = null;
    }

    @Override
    public boolean hasWriteContext() {
        return this.writeContext != null;
    }

    @Override
    public ServiceConfiguration getWriteContext() {
        if(!hasWriteContext()) throw new RuntimeException("No opened write context has been found!");

        return writeContext;
    }
}
