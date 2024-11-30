package dev.duma.android.sunmi.scaninterfacehelper;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

import androidx.annotation.Nullable;

import com.sunmi.scanner_head.IScanInterface;
import com.sunmi.scanner_head.entity.Entity;

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

    int getScannerModel() throws RemoteException;

    void sendCommand(String command) throws RemoteException, ScanInterfaceNotBoundException;

    <T> void sendQuery(String command, IQueryCallback<T> callback) throws RemoteException, ScanInterfaceNotBoundException;

    boolean clearConfig() throws RemoteException;

    @Nullable
    IScanInterface getScanInterface();

    interface IBindCallback {
        void onConnected();
        void onFailedConnection();
        void onDisconnected();
    }

    interface IQueryCallback<T> {
        void onSuccess(T response, Entity<T> entity) throws RemoteException;

        default void onFailed(int i) {
            Log.i("IQueryCallback", "onFailed="+i);
        }

        default void onFailed(String clazz, Entity<T> entity, String message) {
            Log.i("IQueryCallback", "onFailed="+clazz+"; "+message);
        }
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
