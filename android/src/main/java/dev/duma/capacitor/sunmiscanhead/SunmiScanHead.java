package dev.duma.capacitor.sunmiscanhead;

import android.content.Context;
import android.content.Intent;

import dev.duma.android.sunmi.beeper.IBeeper;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver;
import dev.duma.android.sunmi.scanbroadcastreceiver.IScanHeadBroadcastReceiver.ScanCallback;
import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;

public class SunmiScanHead {
    private final SunmiScanHeadConfigurator configurator;
    private final IBeeper beeper;
    private IScanInterfaceHelper scanInterfaceHelper;
    private IScanHeadBroadcastReceiver broadcastReceiver;
    private final Context context;

    public SunmiScanHead(Context context, ScanCallback scanCallback) {
        this.context = context;
        this.configurator = new SunmiScanHeadConfigurator(context, this);

        this.beeper = IBeeper.Factory.make(context);
        this.scanInterfaceHelper = IScanInterfaceHelper.Factory.make(context);
        this.broadcastReceiver = IScanHeadBroadcastReceiver.Factory.make(context, scanCallback);
    }

    public SunmiScanHeadConfigurator getConfigurator() {
        return configurator;
    }

    public IBeeper getBeeper() {
        return beeper;
    }

    public IScanInterfaceHelper getScanInterfaceHelper() {
        return scanInterfaceHelper;
    }

    public void register() {
        getScanInterfaceHelper().bindService();
        broadcastReceiver.register();
    }

    public void unregister() {
        getScanInterfaceHelper().unbindService();
        broadcastReceiver.unregister();
    }

    public void setTrigger(boolean enabled) {
        Intent intent = new Intent();
        intent.setAction("com.sunmi.scanner.ACTION_TRIGGER_CONTROL");
        intent.putExtra("enable",enabled);
        context.sendBroadcast(intent);
    }
}
