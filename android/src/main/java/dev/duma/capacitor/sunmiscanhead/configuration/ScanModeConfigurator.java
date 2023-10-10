package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.TriggerMethodEnum;

public class ScanModeConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public ScanModeConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void trigger() throws RemoteException {
        trigger(5000);
    }

    public void trigger(int timeout) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setTriggerMethod(TriggerMethodEnum.Trigger);
            configuration.setTriggerOverTime(timeout);
            configuration.setScanTriggerTimeOut(timeout);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }

    public void continuous() throws RemoteException {
        continuous(500);
    }

    public void continuous(int sleep) throws RemoteException {
        continuous(sleep, 5000);
    }

    public void continuous(int sleep, int timeout) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setTriggerMethod(TriggerMethodEnum.Continuous);
            configuration.setTriggerOverTime(timeout);
            configuration.setScanTriggerTimeOut(timeout);
            configuration.setTriggerContinuousTime(sleep);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }

    public void pulse() throws RemoteException {
        pulse(5000);
    }

    public void pulse(int timeout) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setTriggerMethod(TriggerMethodEnum.Pulse);
            configuration.setTriggerOverTime(timeout);
            configuration.setScanTriggerTimeOut(timeout);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }

    public void longPress() throws RemoteException {
        longPress(500);
    }

    public void longPress(int sleep) throws RemoteException {
        longPress(sleep, 5000);
    }

    public void longPress(int sleep, int timeout) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setTriggerMethod(TriggerMethodEnum.LongPress);
            configuration.setTriggerOverTime(timeout);
            configuration.setScanTriggerTimeOut(timeout);
            configuration.setTriggerContinuousTime(sleep);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }
}
