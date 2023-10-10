package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;

public class PromptSettingsConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public PromptSettingsConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void set() throws RemoteException {
        set(true, true);
    }

    public void set(boolean sound, boolean vibration) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setVibrate(vibration);
            configuration.setBeep(sound);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }
}
