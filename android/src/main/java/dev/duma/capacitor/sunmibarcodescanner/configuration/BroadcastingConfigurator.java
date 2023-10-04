package dev.duma.capacitor.sunmibarcodescanner.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmibarcodescanner.SunmiBarcodeScanner;
import dev.duma.capacitor.sunmibarcodescanner.SunmiHelper;

public class BroadcastingConfigurator {
    private Context context;
    private SunmiBarcodeScanner sunmiBarcodeScanner;

    public BroadcastingConfigurator(Context context, SunmiBarcodeScanner sunmiBarcodeScanner) {
        this.context = context;
        this.sunmiBarcodeScanner = sunmiBarcodeScanner;
    }

    public void enable() {
        setBroadcast(true);
    }

    public void disable() {
        setBroadcast(false);
    }

    public void setBroadcast(boolean enabled) {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_BROADCAST, enabled ? 1 : 0)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void defaultConfiguration() {
        configure(
            "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED",
            "com.sunmi.scanner.ACTION_SCAN_START",
            "com.sunmi.scanner.ACTION_SCAN_END",
            "data",
            "source_byte"
        );
    }
    public void configure(String scanned_intent, String start_intent, String end_intent, String intent_data_key, String intent_byte_key) {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION, scanned_intent) +
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION_DATA_KEY, intent_data_key) +
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ACTION_BYTE_KEY, intent_byte_key) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_START_DECODE_ACTION, start_intent) +
                SunmiHelper.createCmd(SunmiHelper.SET_SCAN_END_DECODE_ACTION, end_intent)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
