package dev.duma.capacitor.sunmibarcodescanner;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmibarcodescanner.configuration.BroadcastingConfigurator;
import dev.duma.capacitor.sunmibarcodescanner.configuration.CodeTypeConfigurator;
import dev.duma.capacitor.sunmibarcodescanner.configuration.DataOutputModeConfigurator;
import dev.duma.capacitor.sunmibarcodescanner.configuration.ScanModeConfigurator;

public class SunmiBarcodeScannerConfigurator {
    private Context context;
    private SunmiBarcodeScanner sunmiBarcodeScanner;

    public SunmiBarcodeScannerConfigurator(Context context, SunmiBarcodeScanner sunmiBarcodeScanner) {

        this.context = context;
        this.sunmiBarcodeScanner = sunmiBarcodeScanner;
    }

    public ScanModeConfigurator scanMode() {
        return new ScanModeConfigurator(context, sunmiBarcodeScanner);
    }

    public DataOutputModeConfigurator dataOutputMode() {
        return new DataOutputModeConfigurator(context, sunmiBarcodeScanner);
    }

    public BroadcastingConfigurator broadcasting() {
        return new BroadcastingConfigurator(context, sunmiBarcodeScanner);
    }

    public CodeTypeConfigurator codeType() {
        return new CodeTypeConfigurator(context, sunmiBarcodeScanner);
    }







}
