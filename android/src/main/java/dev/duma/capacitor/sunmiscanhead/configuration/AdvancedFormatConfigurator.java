package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiHelper;
import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;

public class AdvancedFormatConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public AdvancedFormatConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void advancedFormat() throws RemoteException {
        advancedFormat(true);
    }
    public void advancedFormat(boolean enabled) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
                SunmiHelper.createCmd(SunmiHelper.SET_ADVANCED_FORMAT, enabled ? 1 : 0)
        );
    }
}
