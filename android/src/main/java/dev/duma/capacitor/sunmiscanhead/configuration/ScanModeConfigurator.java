package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.TriggerMethodEnum;

public class ScanModeConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public ScanModeConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void trigger() {
        trigger(5000);
    }

    public void trigger(int timeout) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setTriggerMethod(TriggerMethodEnum.Trigger);
        configuration.setTriggerOverTime(timeout);
        configuration.setScanTriggerTimeOut(timeout);
    }

    public void continuous() {
        continuous(500);
    }

    public void continuous(int sleep) {
        continuous(sleep, 5000);
    }

    public void continuous(int sleep, int timeout) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setTriggerMethod(TriggerMethodEnum.Continuous);
        configuration.setTriggerOverTime(timeout);
        configuration.setScanTriggerTimeOut(timeout);
        configuration.setTriggerContinuousTime(sleep);
    }

    public void pulse() {
        pulse(5000);
    }

    public void pulse(int timeout) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setTriggerMethod(TriggerMethodEnum.Pulse);
        configuration.setTriggerOverTime(timeout);
        configuration.setScanTriggerTimeOut(timeout);
    }

    public void longPress() {
        longPress(500);
    }

    public void longPress(int sleep) {
        longPress(sleep, 5000);
    }

    public void longPress(int sleep, int timeout) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setTriggerMethod(TriggerMethodEnum.LongPress);
        configuration.setTriggerOverTime(timeout);
        configuration.setScanTriggerTimeOut(timeout);
        configuration.setTriggerContinuousTime(sleep);
    }
}
