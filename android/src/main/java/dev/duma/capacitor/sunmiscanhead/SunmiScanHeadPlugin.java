package dev.duma.capacitor.sunmiscanhead;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.sunmi.scanner.ScannerService;

import java.util.EnumSet;
import java.util.List;

import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver.ScanCallback;
import dev.duma.android.sunmi.scanconfigurationhelper.enums.WriteContextTypeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CenterDecodingSettingEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputEncodingCodeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputTypeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ScanResultCodeIDEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.SpecificSceneEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.TriggerMethodEnum;
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
            implementation.getScanner().scan();

            c.resolve();
        });
    }

    @PluginMethod
    public void stop(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getScanner().stop();

            c.resolve();
        });
    }

    @PluginMethod
    public void getScannerModel(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            int scannerModel = implementation.getScanner().getScannerModel();

            JSObject ret = new JSObject();
            ret.put("id", scannerModel);
            ret.put("name", ScannerService.scannerIdToName(scannerModel));
            
            c.resolve(ret);
        });
    }

    @PluginMethod
    public void clearConfig(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            JSObject ret = new JSObject();

            ret.put("cleared", implementation.getScanner().clearConfig());
            
            c.resolve(ret);
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setTrigger(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getTriggerController().set(c.getBoolean("enabled", true));

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

    @PluginMethod
    public void createWriteContext(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            EnumSet<WriteContextTypeEnum> writeContextTypes = EnumSet.noneOf(WriteContextTypeEnum.class);

            String singleTypeName = call.getString("type");
            JSArray multipleTypeName = call.getArray("type");

            if(singleTypeName == null && (multipleTypeName == null || multipleTypeName.length() == 0)) {
                writeContextTypes = EnumSet.of(WriteContextTypeEnum.Service, WriteContextTypeEnum.CodeFamilies);
            } else if(multipleTypeName != null && multipleTypeName.length() != 0) {
                List<String> typeNames = multipleTypeName.toList();
                for (String type : typeNames) {
                    writeContextTypes.add(
                            WriteContextTypeEnum.nameOf(type)
                    );
                }
            } else if(singleTypeName != null) {
                writeContextTypes.add(
                        WriteContextTypeEnum.nameOf(singleTypeName)
                );
            }

            implementation.getWriteContextTool().createWriteContext((service, codeFamilies) -> {
                c.resolve();
            }, writeContextTypes);
        });
    }

    @PluginMethod
    public void commitWriteContext(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getWriteContextTool().commitWriteContext();

            c.resolve();
        });
    }

    @PluginMethod
    public void discardWriteContext(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            implementation.getWriteContextTool().discardWriteContext();

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setOutputType(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            OutputTypeEnum mode = OutputTypeEnum.nameOf(c.getString("mode", OutputTypeEnum.Disabled.getName()));

            Boolean tab = c.getBoolean("tab", false);
            Boolean enter = c.getBoolean("enter", true);
            Boolean space = c.getBoolean("space", true);

            switch (mode){
                case Keystroke -> {
                    Integer interval = c.getInt("interval", 0);

                    configuration.setOutputType(OutputTypeEnum.Keystroke);

                    try {
                        configuration.setOutputCharacterInterval(interval);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAddTab(tab);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAddSpace(space);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAddReturn(enter);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAsEvents(true);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }

                case DirectFill, DirectFillWithReplace -> {
                    Boolean asEvent = c.getBoolean("asEvent", true);

                    configuration.setOutputType(mode);

                    try {
                        configuration.setAddTab(tab);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAddReturn(enter);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAddSpace(space);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                    try {
                        configuration.setAsEvents(asEvent);
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                }
                case Disabled -> {
                    configuration.setOutputType(OutputTypeEnum.Disabled);
                }
            }

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setTriggerMethod(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            TriggerMethodEnum mode = TriggerMethodEnum.nameOf(c.getString("mode", TriggerMethodEnum.Trigger.getName()));

            final Integer timeout = c.getInt("timeout", 5000);

            configuration.setTriggerMethod(mode);
            configuration.setTriggerOverTime(timeout);
            configuration.setScanTriggerTimeOut(timeout);

            if (mode == TriggerMethodEnum.Continuous || mode == TriggerMethodEnum.LongPress) {
                final Integer sleep = c.getInt("sleep", 500);
                configuration.setTriggerContinuousTime(sleep);
            }

            c.resolve();
        });
    }

    @PluginMethod
    public void setScanResultCodeID(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            ScanResultCodeIDEnum type = ScanResultCodeIDEnum.nameOf(c.getString("type", ScanResultCodeIDEnum.None.getName()));
            configuration.setScanResultCodeID(type);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setAdvancedFormatEnabled(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setAdvancedFormatEnabled(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setBeep(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setBeep(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setVibrate(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setVibrate(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setOutputBroadcastEnabled(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setOutputBroadcastEnabled(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    @PluginMethod
    public void setBroadcastConfiguration(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setOutputBroadcastAction(c.getString("scanned_intent", "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED"));
            configuration.setOutputBroadcastDataKey(c.getString("intent_data_key", "data"));
            configuration.setOutputBroadcastByteKey(c.getString("intent_byte_key", "source_byte"));

            String startIntent = c.getBoolean("start_intent") == null ? c.getString("start_intent", "com.sunmi.scanner.ACTION_SCAN_START") : "";
            configuration.setOutputBroadcastStartAction(startIntent);

            String endIntent = c.getBoolean("end_intent") == null ? c.getString("end_intent", "com.sunmi.scanner.ACTION_SCAN_END") : "";
            configuration.setOutputBroadcastEndAction(endIntent);

            c.resolve();
        });
    }

    @PluginMethod
    public void setOutputEncodingCode(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            OutputEncodingCodeEnum encoding = OutputEncodingCodeEnum.nameOf(c.getString("encoding", OutputEncodingCodeEnum.UTF8.getName()));
            configuration.setOutputEncodingCode(encoding);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setVirtualFloatingScanButton(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setVirtualFloatingScanButton(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    @PluginMethod
    public void setCenterFlagScan(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            CenterDecodingSettingEnum mode = CenterDecodingSettingEnum.nameOf(c.getString("mode", CenterDecodingSettingEnum.Disabled.getName()));
            configuration.setCenterFlagScan(mode);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setFlash(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setFlash(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    @PluginMethod
    public void setScene(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            SpecificSceneEnum scene = SpecificSceneEnum.nameOf(c.getString("scene", SpecificSceneEnum.Default.getName()));
            configuration.setScene(scene);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setRemoveGroupSeparator(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setRemoveGroupSeparator(c.getBoolean("enabled", true));

            c.resolve();
        });
    }

    @PluginMethod
    public void setPrefix(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            String content = c.getString("content", "");
            configuration.setPrefix(content);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setPrefixCharactersRemoved(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setPrefixCharactersRemoved(c.getInt("length", 0));

            c.resolve();
        });
    }

    @PluginMethod
    public void setSuffix(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            String content = c.getString("content", "");
            configuration.setSuffix(content);

            c.resolve();
        });
    }

    /** @noinspection DataFlowIssue*/
    @PluginMethod
    public void setSuffixCharactersRemoved(PluginCall call) {
        CallbackHelper.handle(call, (c) -> {
            ServiceConfiguration configuration = implementation.getWriteContextTool().getServiceWriteContext();

            configuration.setSuffixCharactersRemoved(c.getInt("length", 0));

            c.resolve();
        });
    }
}
