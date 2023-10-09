package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;

public class BroadcastingConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public BroadcastingConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void enable() throws RemoteException {
        setBroadcast(true);
    }

    public void disable() throws RemoteException {
        setBroadcast(false);
    }

    public void setBroadcast(boolean enabled) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setOutputBroadcastEnabled(enabled);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }

    public void defaultConfiguration() throws RemoteException {
        configure(
            "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED",
            "com.sunmi.scanner.ACTION_SCAN_START",
            "com.sunmi.scanner.ACTION_SCAN_END",
            "data",
            "source_byte"
        );
    }

    public void configure(String scanned_intent, String start_intent, String end_intent, String intent_data_key, String intent_byte_key) throws RemoteException {

        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setOutputBroadcastAction(scanned_intent);
            configuration.setOutputBroadcastDataKey(intent_data_key);
            configuration.setOutputBroadcastByteKey(intent_byte_key);
            configuration.setOutputBroadcastStartAction(start_intent);
            configuration.setOutputBroadcastEndAction(end_intent);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }
}
