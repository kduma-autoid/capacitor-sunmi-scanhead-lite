package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;
import dev.duma.capacitor.sunmiscanhead.SunmiHelper;

public class BroadcastingConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public BroadcastingConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void enable() throws RemoteException {
        setBroadcast(true);
    }

    public void disable() throws RemoteException {
        setBroadcast(false);
    }

    public void setBroadcast(boolean enabled) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_BROADCAST, enabled ? 1 : 0)
        );
    }


    public void defaultConfiguration() throws RemoteException {
        configure(
            "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED",
            "com.sunmi.scanner.ACTION_SCAN_START",
            "com.sunmi.scanner.ACTION_SCAN_END",
            "data",
            "source_byte"
        );
    }
    public void configure(String scanned_intent, String start_intent, String end_intent, String intent_data_key, String intent_byte_key) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION, scanned_intent)
        );
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION_DATA_KEY, intent_data_key)
        );
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION_BYTE_KEY, intent_byte_key)
        );
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_START_DECODE_ACTION, start_intent)
        );
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_SCAN_END_DECODE_ACTION, end_intent)
        );
    }
}
