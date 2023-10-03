package dev.duma.capacitor.sunmibarcodescanner;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

import com.sunmi.scanner.IScanInterface;

public class SunmiBarcodeScanner {
    private IScanInterface scanInterface;
    private final Context context;
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            scanInterface = IScanInterface.Stub.asInterface(service);
            if (scanInterface == null) {
                Log.i("setting", "Scanner Service Failed To Connect!");
            } else {
                Log.i("setting", "Scanner Service Connected!");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("setting", "Scanner Service Disconnected!");
            scanInterface = null;
        }
    };


    public SunmiBarcodeScanner(Context context) {
        this.context = context;
    }

    public void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.sunmi.scanner");
        intent.setAction("com.sunmi.scanner.IScanInterface");
        context.getApplicationContext().bindService(intent, connection, Service.BIND_AUTO_CREATE);
    }

    public void unbindService() {
        if (scanInterface == null) return;

        context.getApplicationContext().unbindService(connection);
        scanInterface = null;
    }

    public void sendKeyEvent(KeyEvent key) {
        if (scanInterface == null) return;

        try {
            scanInterface.sendKeyEvent(key);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void scan() {
        if (scanInterface == null) return;

        try {
            scanInterface.scan();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        if (scanInterface == null) return;

        try {
            scanInterface.stop();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public int getScannerModel() {
        if (scanInterface == null) return 0;

        try {
            return scanInterface.getScannerModel();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
