package dev.duma.capacitor.sunmiscanhead;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.configuration.BroadcastingConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.CodeTypeConfigurator;
import dev.duma.capacitor.sunmiscanhead.configuration.DataOutputModeConfigurator;
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







}
