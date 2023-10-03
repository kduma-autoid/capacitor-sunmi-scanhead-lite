package dev.duma.capacitor.sunmibarcodescanner;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "SunmiBarcodeScanner")
public class SunmiBarcodeScannerPlugin extends Plugin {

    private SunmiBarcodeScanner implementation;

    @Override
    public void load() {
        implementation = new SunmiBarcodeScanner(getContext());
        super.load();

        boolean bindOnLoad = getConfig().getBoolean("bindOnLoad", true);
        if(bindOnLoad) {
            try {
                implementation.bindService();
            } catch (RuntimeException e) {
                // ignore
            }
        }
    }

    @PluginMethod
    public void bindService(PluginCall call) {
        implementation.bindService();
        call.resolve();
    }

    @PluginMethod
    public void disconnectService(PluginCall call) {
        implementation.unbindService();
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
