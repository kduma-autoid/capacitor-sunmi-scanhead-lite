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



    public void trigger() {
        trigger(5000);
    }
    public void trigger(int timeout) {
        IScanInterface scanInterface = SunmiScanHead.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 0) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 0) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }



    public void continuous() {
        continuous(500);
    }
    public void continuous(int sleep) {
        continuous(sleep, 5000);
    }
    public void continuous(int sleep, int timeout) {
        IScanInterface scanInterface = SunmiScanHead.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 1) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 1) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_CONTINUOUS_TIME, sleep)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void pulse() {
        pulse(5000);
    }
    public void pulse(int timeout) {
        IScanInterface scanInterface = SunmiScanHead.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 2) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 2) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void longPress() {
        longPress(500);
    }
    public void longPress(int sleep) {
        longPress(sleep, 5000);
    }
    public void longPress(int sleep, int timeout) {
        IScanInterface scanInterface = SunmiScanHead.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_METHOD, 3) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_METHOD, 3) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_OVER_TIME, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_TRIGGER_TIME_OUT, timeout) +
                SunmiHelper.createCmd(SunmiHelper.SET_TRIGGER_CONTINUOUS_TIME, sleep)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
