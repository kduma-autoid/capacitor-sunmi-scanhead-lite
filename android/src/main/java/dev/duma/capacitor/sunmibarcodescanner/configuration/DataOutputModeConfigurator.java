package dev.duma.capacitor.sunmibarcodescanner.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmibarcodescanner.SunmiBarcodeScanner;
import dev.duma.capacitor.sunmibarcodescanner.SunmiHelper;

public class DataOutputModeConfigurator {
    private Context context;
    private SunmiBarcodeScanner sunmiBarcodeScanner;

    public DataOutputModeConfigurator(Context context, SunmiBarcodeScanner sunmiBarcodeScanner) {
        this.context = context;
        this.sunmiBarcodeScanner = sunmiBarcodeScanner;
    }



    public void keystroke() {
        keystroke(0, false, true);
    }
    public void keystroke(int interval, boolean tab, boolean enter) {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;


        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, 2) +
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_CHAR_INTERVAL, interval) +
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_AUTO_ADD, new int[] { tab ? 1 : 0, enter ? 1 : 0, 1 })
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void directFill() {
        directFill(false, false, true, true);
    }
    public void directFill(boolean overwrite, boolean tab, boolean enter, boolean asEvents) {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;


        try {
            scanInterface.sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, overwrite ? 1 : 0) +
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_AUTO_ADD, new int[] { tab ? 1 : 0, enter ? 1 : 0, asEvents ? 1 : 0 })
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }


    public void disabled() {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;


        try {
            scanInterface.sendCommand(
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_TYPE, 3)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
