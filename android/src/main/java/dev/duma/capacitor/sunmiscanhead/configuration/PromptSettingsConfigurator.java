package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;

public class PromptSettingsConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public PromptSettingsConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void set() {
        set(true, true);
    }

    public void set(boolean sound, boolean vibration) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setVibrate(vibration); // TODO: Catch exception
        configuration.setBeep(sound);
    }
}
