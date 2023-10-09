package dev.duma.capacitor.sunmiscanhead;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.sunmi.scanner.IScanInterface;

public class SunmiScanHead {
    private final SunmiScanHeadConfigurator configurator;
    private final Beeper beeper;
    private IScanInterface scanInterface;
    private final Context context;
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            scanInterface = IScanInterface.Stub.asInterface(service);
            if (scanInterface == null) {
                Log.i("SunmiScanHead", "Scanner Service Failed To Connect!");
            } else {
                Log.i("SunmiScanHead", "Scanner Service Connected!");
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("SunmiScanHead", "Scanner Service Disconnected!");
            scanInterface = null;
        }
    };


    public SunmiScanHead(Context context) {
        this.context = context;
        this.configurator = new SunmiScanHeadConfigurator(context, this);
        this.beeper = new Beeper(context);
    }

    public SunmiScanHeadConfigurator getConfigurator() {
        return configurator;
    }

    public Beeper getBeeper() {
        return beeper;
    }

    @Nullable
    public IScanInterface getScanInterface() {
        return scanInterface;
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

    public void clearConfig() {
        if (scanInterface == null) return;

        try {
            scanInterface.clearConfig();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void setTrigger(boolean enabled) {
        Intent intent = new Intent();
        intent.setAction("com.sunmi.scanner.ACTION_TRIGGER_CONTROL");
        intent.putExtra("enable",enabled);
        context.sendBroadcast(intent);
    }
}
