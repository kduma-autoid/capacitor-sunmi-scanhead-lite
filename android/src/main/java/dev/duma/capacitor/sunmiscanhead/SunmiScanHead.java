package dev.duma.capacitor.sunmiscanhead;

import android.content.Context;

import dev.duma.android.sunmi.beeper.IBeeper;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver.ScanCallback;
import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scantriggercontrol.ITriggerControlHelper;
import dev.duma.capacitor.sunmiscanhead.configuration.SunmiScanHeadConfigurator;

public class SunmiScanHead {
    private final SunmiScanHeadConfigurator configurator;
    private final IBeeper beeper;
    private final IScanInterfaceHelper scanInterfaceHelper;
    private final IScanConfigurationHelper scanConfigurationHelper;
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;
    private final IScanHeadBroadcastReceiver broadcastReceiver;
    private final Context context;
    private final ITriggerControlHelper triggerControlHelper;

    public SunmiScanHead(Context context, ScanCallback scanCallback) {
        this.context = context;

        this.beeper = IBeeper.Factory.make(context);
        this.scanInterfaceHelper = IScanInterfaceHelper.Factory.make(context);
        this.scanConfigurationHelper = IScanConfigurationHelper.Factory.make(scanInterfaceHelper);
        this.configurationWriteContextHelper = IConfigurationWriteContextHelper.Factory.make(scanConfigurationHelper);
        this.triggerControlHelper = ITriggerControlHelper.Factory.make(context);
        this.broadcastReceiver = IScanHeadBroadcastReceiver.Factory.make(context, scanCallback);

        this.configurator = new SunmiScanHeadConfigurator(configurationWriteContextHelper);
    }

    public SunmiScanHeadConfigurator getConfigurator() {
        return configurator;
    }

    public IBeeper getBeeper() {
        return beeper;
    }

    public IScanInterfaceHelper getScanner() {
        return scanInterfaceHelper;
    }

    public ITriggerControlHelper getTriggerController() {
        return triggerControlHelper;
    }

    public IConfigurationWriteContextHelper getWriteContextTool() {
        return configurationWriteContextHelper;
    }

    public void register() {
        scanInterfaceHelper.bindService();
        broadcastReceiver.register();
    }

    public void unregister() {
        scanInterfaceHelper.unbindService();
        broadcastReceiver.unregister();
    }
}
