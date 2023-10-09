package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;
import dev.duma.capacitor.sunmiscanhead.SunmiHelper;

public class ScanModeConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public ScanModeConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void trigger() throws RemoteException {
        trigger(5000);
    }

    public void trigger(int timeout) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 0) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 0) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout)
        );
    }

    public void continuous() throws RemoteException {
        continuous(500);
    }

    public void continuous(int sleep) throws RemoteException {
        continuous(sleep, 5000);
    }

    public void continuous(int sleep, int timeout) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 1) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 1) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_CONTINUOUS_TIME, sleep)
        );
    }

    public void pulse() throws RemoteException {
        pulse(5000);
    }

    public void pulse(int timeout) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 2) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 2) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout)
        );
    }

    public void longPress() throws RemoteException {
        longPress(500);
    }

    public void longPress(int sleep) throws RemoteException {
        longPress(sleep, 5000);
    }

    public void longPress(int sleep, int timeout) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 3) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 3) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout) +
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_CONTINUOUS_TIME, sleep)
        );
    }
}
