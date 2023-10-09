package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;
import dev.duma.capacitor.sunmiscanhead.SunmiHelper;

public class DataOutputModeConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public DataOutputModeConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void keystroke() throws RemoteException {
        keystroke(0, false, true);
    }

    public void keystroke(int interval, boolean tab, boolean enter) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, 2) +
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CHAR_INTERVAL, interval) +
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_AUTO_ADD, new int[] { tab ? 1 : 0, enter ? 1 : 0, 1 })
        );
    }

    public void directFill() throws RemoteException {
        directFill(false, false, true, true);
    }

    public void directFill(boolean overwrite, boolean tab, boolean enter, boolean asEvents) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, overwrite ? 1 : 0) +
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_AUTO_ADD, new int[] { tab ? 1 : 0, enter ? 1 : 0, asEvents ? 1 : 0 })
        );
    }

    public void disabled() throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, 3)
        );
    }
}
