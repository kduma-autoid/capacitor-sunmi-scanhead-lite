package dev.duma.capacitor.sunmiscanhead;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.sunmi.scanner.ScannerService;

import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver.ScanCallback;
import dev.duma.capacitor.pluginhelpers.CallbackHelper;

@CapacitorPlugin(name = "SunmiScanHead")
public class SunmiScanHeadPlugin extends Plugin {
    private final ScanCallback scanCallback = new ScanCallback() {
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

    @Override
    public void load() {
        implementation = new SunmiScanHead(getContext(), scanCallback);

        if(getConfig().getBoolean("bindOnLoad", true)) {
            try {
                implementation.register();
            } catch (RuntimeException e) {
                // ignore
            }
        }

        super.load();
    }

    @PluginMethod
    public void bindService(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.register();
            c.resolve();
        });
    }

    @PluginMethod
    public void unBindService(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.unregister();
            c.resolve();
        });
    }

    @PluginMethod
    public void scan(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getScanInterfaceHelper().scan();
            c.resolve();
        });
    }

    @PluginMethod
    public void stop(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getScanInterfaceHelper().stop();
            c.resolve();
        });
    }

    @PluginMethod
    public void getScannerModel(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            int scannerModel = implementation.getScanInterfaceHelper().getScannerModel();

            JSObject ret = new JSObject();
            ret.put("id", scannerModel);
            ret.put("name", ScannerService.scannerIdToName(scannerModel));
            
            c.resolve(ret);
        });
    }

    @PluginMethod
    public void clearConfig(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            boolean status = implementation.getScanInterfaceHelper().clearConfig();

            JSObject ret = new JSObject();
            ret.put("cleared", status);
            
            c.resolve(ret);
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setTrigger(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getTriggerControlHelper().set(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setOutputMode(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            switch (c.getString("mode", "disabled")){
                default -> implementation.getConfigurator().dataOutputMode().disabled();

                case "keystroke" -> implementation.getConfigurator().dataOutputMode().keystroke(
                        c.getInt("interval", 0),
                        c.getBoolean("tab", false),
                        c.getBoolean("enter", true)
                );

                case "directFill" -> implementation.getConfigurator().dataOutputMode().directFill(
                        c.getBoolean("overwrite", false),
                        c.getBoolean("tab", false),
                        c.getBoolean("enter", true),
                        c.getBoolean("asEvent", true)
                );
            }

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setScanMode(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            switch (c.getString("mode", "trigger")){
                default -> implementation.getConfigurator().scanMode().trigger(
                        c.getInt("timeout", 5000)
                );

                case "continuous" -> implementation.getConfigurator().scanMode().continuous(
                        c.getInt("sleep", 500),
                        c.getInt("timeout", 5000)
                );

                case "pulse" -> implementation.getConfigurator().scanMode().pulse(
                        c.getInt("timeout", 5000)
                );

                case "longPress" -> implementation.getConfigurator().scanMode().longPress(
                        c.getInt("sleep", 500),
                        c.getInt("timeout", 5000)
                );
            }

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setReturnCodeType(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getConfigurator().codeType().returnCodeType(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setAdvancedFormat(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getConfigurator().advancedFormat().advancedFormat(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setPromptSettings(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getConfigurator().promptSettings().set(
                    c.getBoolean("sound", true),
                    c.getBoolean("vibrations", c.getBoolean("sound", true))
            );

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setBroadcast(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getConfigurator().broadcasting().setBroadcast(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    @PluginMethod
    public void setBroadcastConfiguration(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getConfigurator().broadcasting().configure(
                    c.getString("scanned_intent", "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"),
                    c.getString("start_intent", "com.sunmi.scanner.ACTION_SCAN_START"),
                    c.getString("end_intent", "com.sunmi.scanner.ACTION_SCAN_END"),
                    c.getString("intent_data_key", "data"),
                    c.getString("intent_byte_key", "source_byte")
            );

            c.resolve();
        });
    }

    @PluginMethod
    public void beep(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getBeeper().beep();

            c.resolve();
        });
    }

    @PluginMethod
    public void vibrate(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getBeeper().vibrate();

            c.resolve();
        });
    }
}
