package dev.duma.capacitor.sunmibarcodescanner;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SunmiBarcodeScanner")
public class SunmiBarcodeScannerPlugin extends Plugin {
    private final SunmiBarcodeScannerBroadcastReceiver.ScanCallback receiverCallback = new SunmiBarcodeScannerBroadcastReceiver.ScanCallback() {
        @Override
        public void onScan(String data, String source_bytes) {
            JSObject ret = new JSObject();
            ret.put("data", data);
            ret.put("source_bytes", source_bytes);
            notifyListeners("onScanResult", ret);
        }

        @Override
        public void onStart() {
            notifyListeners("onScanStart", new JSObject());
        }

        @Override
        public void onStop() {
            notifyListeners("onScanStop", new JSObject());
        }
    };

    private SunmiBarcodeScanner implementation;
    private SunmiBarcodeScannerBroadcastReceiver broadcastReceiver;

    @Override
    public void load() {
        implementation = new SunmiBarcodeScanner(getContext());
        broadcastReceiver = new SunmiBarcodeScannerBroadcastReceiver(getContext(), receiverCallback);

        if(getConfig().getBoolean("bindOnLoad", true)) {
            try {
                implementation.bindService();
                broadcastReceiver.register();
            } catch (RuntimeException e) {
                // ignore
            }
        }

        super.load();
    }

    @PluginMethod
    public void bindService(PluginCall call) {
        implementation.bindService();
        broadcastReceiver.register();
        call.resolve();
    }

    @PluginMethod
    public void disconnectService(PluginCall call) {
        implementation.unbindService();
        broadcastReceiver.unregister();
        call.resolve();
    }

//    @PluginMethod
//    public void sendKeyEvent(PluginCall call) {
//        implementation.sendKeyEvent(
//            new KeyEvent(
//                call.getInt("action", 0),
//                call.getInt("code", 0)
//            )
//        );
//        call.resolve();
//    }

    @PluginMethod
    public void scan(PluginCall call) {
        implementation.scan();
        call.resolve();
    }

    @PluginMethod
    public void stop(PluginCall call) {
        implementation.stop();
        call.resolve();
    }

    @PluginMethod
    public void getScannerModel(PluginCall call) {
        JSObject ret = new JSObject();
        ret.put("model", implementation.getScannerModel());
        call.resolve(ret);
    }
}
