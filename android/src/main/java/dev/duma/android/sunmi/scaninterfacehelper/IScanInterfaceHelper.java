package dev.duma.android.sunmi.scaninterfacehelper;

import android.content.Context;
import android.os.RemoteException;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.sunmi.scanner.IScanInterface;

import dev.duma.android.sunmi.scaninterfacehelper.exceptions.ScanInterfaceNotBoundException;

public interface IScanInterfaceHelper {
    /**
     * Binds service
     */
    void bindService();

    /**
     * Unbind service
     */
    void unbindService();

    void sendKeyEvent(KeyEvent key) throws RemoteException, ScanInterfaceNotBoundException;

    void scan() throws RemoteException, ScanInterfaceNotBoundException;

    void stop() throws RemoteException, ScanInterfaceNotBoundException;

    int getScannerModel() throws RemoteException, ScanInterfaceNotBoundException;

    void sendCommand(String command) throws RemoteException, ScanInterfaceNotBoundException;

    boolean clearConfig() throws RemoteException, ScanInterfaceNotBoundException;

    @Nullable
    IScanInterface getScanInterface();

    interface IBindCallback {
        void onConnected();
        void onFailedConnection();
        void onDisconnected();
    }

    class Factory
    {
        static public IScanInterfaceHelper make(Context context) {
            return make(context, null);
        }

        static public IScanInterfaceHelper make(Context context, IBindCallback callback) {
            return new ScanInterfaceHelper(context, callback);
        }
    }
}
