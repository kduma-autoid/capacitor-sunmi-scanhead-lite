package dev.duma.android.sunmi.scanbroadcastreceiver;

import android.annotation.SuppressLint;
import android.content.Context;

import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scaninterfacehelper.ScanInterfaceHelper;

public interface IScanHeadBroadcastReceiver {
    void register();

    void unregister();

    interface ScanCallback {
        void onScan(String data, String source_bytes);
        void onStart();
        void onStop();
    }

    class Factory
    {
        static public IScanHeadBroadcastReceiver make(Context context, ScanCallback callback) {
            return new ScanHeadBroadcastReceiver(context, callback);
        }
    }
}
