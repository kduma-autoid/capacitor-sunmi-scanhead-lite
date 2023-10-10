package dev.duma.capacitor.sunmiscanhead;

import android.content.Context;

import dev.duma.android.sunmi.beeper.IBeeper;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver.ScanCallback;
import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scantriggercontrol.ITriggerControlHelper;

public class SunmiScanHead {
    private final IBeeper beeper;
    private final IScanInterfaceHelper scanInterfaceHelper;
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;
    private final IScanHeadBroadcastReceiver broadcastReceiver;
    private final ITriggerControlHelper triggerControlHelper;

    public SunmiScanHead(Context context, ScanCallback scanCallback) {
        this.beeper = IBeeper.Factory.make(context);
        this.scanInterfaceHelper = IScanInterfaceHelper.Factory.make(context);
        IScanConfigurationHelper scanConfigurationHelper = IScanConfigurationHelper.Factory.make(scanInterfaceHelper);
        this.configurationWriteContextHelper = IConfigurationWriteContextHelper.Factory.make(scanConfigurationHelper);
        this.triggerControlHelper = ITriggerControlHelper.Factory.make(context);
        this.broadcastReceiver = IScanHeadBroadcastReceiver.Factory.make(context, scanCallback);
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
