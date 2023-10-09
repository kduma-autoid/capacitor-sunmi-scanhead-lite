package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.models.OutputTypeEnum;

public class DataOutputModeConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public DataOutputModeConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void keystroke() throws RemoteException {
        keystroke(0, false, true);
    }

    public void keystroke(int interval, boolean tab, boolean enter) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setOutputType(OutputTypeEnum.Keystroke);
            configuration.setOutputCharacterInterval(interval);
            configuration.setAddTab(tab);
            configuration.setAddReturn(enter);
            configuration.setAsEvents(true);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }

    public void directFill() throws RemoteException {
        directFill(false, false, true, true);
    }

    public void directFill(boolean overwrite, boolean tab, boolean enter, boolean asEvents) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setOutputType(overwrite ? OutputTypeEnum.DirectFillWithReplace : OutputTypeEnum.DirectFill);
            configuration.setAddTab(tab);
            configuration.setAddReturn(enter);
            configuration.setAsEvents(asEvents);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }

    public void disabled() throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setOutputType(OutputTypeEnum.Disabled);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }
}
