package dev.duma.capacitor.sunmiscanhead.configuration;


import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;

public class SunmiScanHeadConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public SunmiScanHeadConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public ScanModeConfigurator scanMode() {
        return new ScanModeConfigurator(scanConfigurationHelper);
    }

    public DataOutputModeConfigurator dataOutputMode() {
        return new DataOutputModeConfigurator(scanConfigurationHelper);
    }

    public BroadcastingConfigurator broadcasting() {
        return new BroadcastingConfigurator(scanConfigurationHelper);
    }

    public CodeTypeConfigurator codeType() {
        return new CodeTypeConfigurator(scanConfigurationHelper);
    }

    public PromptSettingsConfigurator promptSettings() {
        return new PromptSettingsConfigurator(scanConfigurationHelper);
    }

    public AdvancedFormatConfigurator advancedFormat() {
        return new AdvancedFormatConfigurator(scanConfigurationHelper);
    }







}
