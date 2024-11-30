package dev.duma.android.sunmi.scaninterfacehelper;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.sunmi.scanner.ICallBack;
import com.sunmi.scanner.IScanInterface;
import com.sunmi.scanner.entity.Entity;

import dev.duma.android.sunmi.scaninterfacehelper.exceptions.ScanInterfaceNotBoundException;

public class ScanInterfaceHelper implements IScanInterfaceHelper {
    private final Context context;
    private final IBindCallback callback;
    private IScanInterface scanInterface;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            scanInterface = IScanInterface.Stub.asInterface(service);

            if (callback != null) {
                if (scanInterface == null) {
                        callback.onFailedConnection();
                } else {
                    callback.onConnected();
                }
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            if (callback != null) {
                callback.onDisconnected();
            }
            scanInterface = null;
        }
    };

    public ScanInterfaceHelper(Context context, IBindCallback callback) {
        this.context = context;
        this.callback = callback;
    }


    @Override
    public void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.sunmi.scanner");
        intent.setAction("com.sunmi.scanner.IScanInterface");
        context.getApplicationContext().bindService(intent, connection, Service.BIND_AUTO_CREATE);
    }

    @Override
    public void unbindService() {
        if (scanInterface == null) return;

        context.getApplicationContext().unbindService(connection);
        scanInterface = null;
    }

    @Override
    public void sendKeyEvent(KeyEvent key) throws RemoteException {
        if (scanInterface == null) throw new ScanInterfaceNotBoundException();

        scanInterface.sendKeyEvent(key);
    }

    @Override
    public void scan() throws RemoteException {
        if (scanInterface == null) throw new ScanInterfaceNotBoundException();

        scanInterface.scan();
    }

    @Override
    public void stop() throws RemoteException {
        if (scanInterface == null) throw new ScanInterfaceNotBoundException();

        scanInterface.stop();
    }

    @Override
    public int getScannerModel() throws RemoteException {
        if (scanInterface == null) return 0;

        return scanInterface.getScannerModel();
    }

    @Override
    public void sendCommand(String command) throws RemoteException {
        if (scanInterface == null) throw new ScanInterfaceNotBoundException();

        scanInterface.sendCommand(command);
    }

    @Override
    public <T> void sendQuery(String command, IQueryCallback<T> callback) throws RemoteException, ScanInterfaceNotBoundException {
        if (scanInterface == null) throw new ScanInterfaceNotBoundException();

        scanInterface.sendQuery(command, new ICallBack.Stub() {
            @Override
            public void onSuccess(Entity entity) throws RemoteException {
                Object bean = entity.getBean();

                try {
                    callback.onSuccess((T) bean, entity);
                } catch (ClassCastException e) {
                    callback.onFailed(entity.getClazz(), entity, e.getMessage());
                }
            }

            @Override
            public void onFiled(int i) throws RemoteException {
                callback.onFailed(i);
            }
        });
    }

    @Override
    public boolean clearConfig() throws RemoteException {
        if (scanInterface == null) return false;

        return scanInterface.clearConfig();
    }

    @Override
    @Nullable
    public IScanInterface getScanInterface() {
        return scanInterface;
    }
}
