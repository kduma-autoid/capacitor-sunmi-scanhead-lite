package dev.duma.capacitor.sunmibarcodescanner.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmibarcodescanner.SunmiBarcodeScanner;
import dev.duma.capacitor.sunmibarcodescanner.SunmiHelper;

public class CodeTypeConfigurator {
    private Context context;
    private SunmiBarcodeScanner sunmiBarcodeScanner;

    public CodeTypeConfigurator(Context context, SunmiBarcodeScanner sunmiBarcodeScanner) {
        this.context = context;
        this.sunmiBarcodeScanner = sunmiBarcodeScanner;
    }

    public void returnCodeType() {
        returnCodeType(true);
    }
    public void returnCodeType(boolean enabled) {
        IScanInterface scanInterface = sunmiBarcodeScanner.getScanInterface();
        if (scanInterface == null) return;

        try {
            scanInterface.sendCommand(
                SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ID, enabled ? 1 : 0)
            );
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
