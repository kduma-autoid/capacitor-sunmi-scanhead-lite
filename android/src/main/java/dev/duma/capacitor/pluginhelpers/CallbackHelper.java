package dev.duma.capacitor.pluginhelpers;

import android.os.RemoteException;

import com.getcapacitor.PluginCall;

import org.json.JSONException;

public class CallbackHelper {
    public interface IAction {
        void onExecute(PluginCall call) throws RemoteException, RuntimeException, JSONException;
    }
    public interface IExceptionHandler {
        void onException(PluginCall call, Exception exception);
    }

    static public void handle(PluginCall call, IAction action) {
        handle(call, action, (c, e) -> c.reject(e.getMessage(), e));
    }

    static public void handle(PluginCall call, IAction action, IExceptionHandler exceptionHandler) {
        try {
            action.onExecute(call);
        } catch (RuntimeException | RemoteException | JSONException e) {
            e.printStackTrace();
            exceptionHandler.onException(call, e);
        }
    }
}
