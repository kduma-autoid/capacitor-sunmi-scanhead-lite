package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiHelper;
import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;

public class PromptSettingsConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public PromptSettingsConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void set() {
        set(true, true);
    }
    public void set(boolean sound, boolean vibration) {
        IScanInterface scanInterface = SunmiScanHead.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
                SunmiHelper.createCmd(SunmiHelper.SET_TIPS, new int[] { sound ? 1 : 0, vibration ? 1 : -1 })
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
