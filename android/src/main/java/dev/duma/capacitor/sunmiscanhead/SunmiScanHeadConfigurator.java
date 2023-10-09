package dev.duma.capacitor.sunmiscanhead;

import android.content.Context;

import dev.duma.capacitor.sunmiscanhead.configuration.AdvancedFormatConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.BroadcastingConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.CodeTypeConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.DataOutputModeConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.PromptSettingsConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.ScanModeConfigurator;

public class SunmiScanHeadConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public SunmiScanHeadConfigurator(Context context, SunmiScanHead SunmiScanHead) {

        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public ScanModeConfigurator scanMode() {
        return new ScanModeConfigurator(context, SunmiScanHead);
    }

    public DataOutputModeConfigurator dataOutputMode() {
        return new DataOutputModeConfigurator(context, SunmiScanHead);
    }

    public BroadcastingConfigurator broadcasting() {
        return new BroadcastingConfigurator(context, SunmiScanHead);
    }

    public CodeTypeConfigurator codeType() {
        return new CodeTypeConfigurator(context, SunmiScanHead);
    }

    public PromptSettingsConfigurator promptSettings() {
        return new PromptSettingsConfigurator(context, SunmiScanHead);
    }

    public AdvancedFormatConfigurator advancedFormat() {
        return new AdvancedFormatConfigurator(context, SunmiScanHead);
    }







}
