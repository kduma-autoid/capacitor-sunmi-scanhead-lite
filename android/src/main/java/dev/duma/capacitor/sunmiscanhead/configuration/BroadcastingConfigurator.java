package dev.duma.capacitor.sunmiscanhead.configuration;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;

public class BroadcastingConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public BroadcastingConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void defaultConfiguration() {
        configure(
            "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED",
            "com.sunmi.scanner.ACTION_SCAN_START",
            "com.sunmi.scanner.ACTION_SCAN_END",
            "data",
            "source_byte"
        );
    }

    public void configure(String scanned_intent, String start_intent, String end_intent, String intent_data_key, String intent_byte_key) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setOutputBroadcastAction(scanned_intent);
        configuration.setOutputBroadcastDataKey(intent_data_key);
        configuration.setOutputBroadcastByteKey(intent_byte_key);
        configuration.setOutputBroadcastStartAction(start_intent);
        configuration.setOutputBroadcastEndAction(end_intent);
    }
}
