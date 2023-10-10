package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;

public class AdvancedFormatConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public AdvancedFormatConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void advancedFormat() throws RemoteException {
        advancedFormat(true);
    }

    public void advancedFormat(boolean enabled) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setAdvancedFormatEnabled(enabled);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }
}
