package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;

public class AdvancedFormatConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public AdvancedFormatConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void advancedFormat() {
        advancedFormat(true);
    }

    public void advancedFormat(boolean enabled) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setAdvancedFormatEnabled(enabled);
    }
}
