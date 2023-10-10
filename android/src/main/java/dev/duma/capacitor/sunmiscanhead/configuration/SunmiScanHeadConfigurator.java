package dev.duma.capacitor.sunmiscanhead.configuration;


import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;

public class SunmiScanHeadConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public SunmiScanHeadConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public DataOutputModeConfigurator dataOutputMode() {
        return new DataOutputModeConfigurator(configurationWriteContextHelper);
    }
}
