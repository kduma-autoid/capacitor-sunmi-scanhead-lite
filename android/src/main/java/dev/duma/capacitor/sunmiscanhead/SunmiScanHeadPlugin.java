package dev.duma.capacitor.sunmiscanhead;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.sunmi.scanner.ScannerService;

@CapacitorPlugin(name = "SunmiScanHead")
public class SunmiScanHeadPlugin extends Plugin {
    private final SunmiScanHeadBroadcastReceiver.ScanCallback receiverCallback = new SunmiScanHeadBroadcastReceiver.ScanCallback() {
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

    private SunmiScanHead implementation;
    private SunmiScanHeadBroadcastReceiver broadcastReceiver;

    @Override
    public void load() {
        implementation = new SunmiScanHead(getContext());
        broadcastReceiver = new SunmiScanHeadBroadcastReceiver(getContext(), receiverCallback);

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
        int scannerModel = implementation.getScannerModel();
        ret.put("id", scannerModel);
        ret.put("name", ScannerService.scannerIdToName(scannerModel));
        call.resolve(ret);
    }

    @PluginMethod
    public void clearConfig(PluginCall call) {
        implementation.clearConfig();

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setTrigger(PluginCall call) {
        implementation.setTrigger(call.getBoolean("enabled", true));

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setOutputMode(PluginCall call) {
        switch (call.getString("mode", "disabled")){
            default -> implementation.getConfigurator().dataOutputMode().disabled();

            case "keystroke" -> implementation.getConfigurator().dataOutputMode().keystroke(
                call.getInt("interval", 0),
                call.getBoolean("tab", false),
                call.getBoolean("enter", true)
            );

            case "directFill" -> implementation.getConfigurator().dataOutputMode().directFill(
                call.getBoolean("overwrite", false),
                call.getBoolean("tab", false),
                call.getBoolean("enter", true),
                call.getBoolean("asEvent", true)
            );
        }

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setScanMode(PluginCall call) {
        switch (call.getString("mode", "trigger")){
            default -> implementation.getConfigurator().scanMode().trigger(
                call.getInt("timeout", 5000)
            );

            case "continuous" -> implementation.getConfigurator().scanMode().continuous(
                    call.getInt("sleep", 500),
                    call.getInt("timeout", 5000)
            );

            case "pulse" -> implementation.getConfigurator().scanMode().pulse(
                    call.getInt("timeout", 5000)
            );

            case "longPress" -> implementation.getConfigurator().scanMode().longPress(
                    call.getInt("sleep", 500),
                    call.getInt("timeout", 5000)
            );
        }

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setReturnCodeType(PluginCall call) {
        implementation.getConfigurator().codeType().returnCodeType(call.getBoolean("enabled", true));

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setAdvancedFormat(PluginCall call) {
        implementation.getConfigurator().advancedFormat().advancedFormat(call.getBoolean("enabled", true));

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setPromptSettings(PluginCall call) {
        implementation.getConfigurator().promptSettings().set(
            call.getBoolean("sound", true),
            call.getBoolean("vibrations", call.getBoolean("sound", true))
        );

        call.resolve();
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setBroadcast(PluginCall call) {
        implementation.getConfigurator().broadcasting().setBroadcast(call.getBoolean("enabled", true));

        call.resolve();
    }

    @PluginMethod
    public void setBroadcastConfiguration(PluginCall call) {
        implementation.getConfigurator().broadcasting().configure(
            call.getString("scanned_intent", "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"),
            call.getString("start_intent", "com.sunmi.scanner.ACTION_SCAN_START"),
            call.getString("end_intent", "com.sunmi.scanner.ACTION_SCAN_END"),
            call.getString("intent_data_key", "data"),
            call.getString("intent_byte_key", "source_byte")
        );

        call.resolve();
    }

    @PluginMethod
    public void beep(PluginCall call) {
        implementation.getBeeper().beep();

        call.resolve();
    }

    @PluginMethod
    public void vibrate(PluginCall call) {
        implementation.getBeeper().vibrate();

        call.resolve();
    }
}
