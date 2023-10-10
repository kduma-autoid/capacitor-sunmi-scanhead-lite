package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputTypeEnum;

public class DataOutputModeConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public DataOutputModeConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void keystroke() throws RemoteException {
        keystroke(0, false, true);
    }

    public void keystroke(int interval, boolean tab, boolean enter) throws RemoteException {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setOutputType(OutputTypeEnum.Keystroke);
        configuration.setOutputCharacterInterval(interval);
        configuration.setAddTab(tab);
        configuration.setAddReturn(enter);
        configuration.setAsEvents(true);
    }

    public void directFill() throws RemoteException {
        directFill(false, false, true, true);
    }

    public void directFill(boolean overwrite, boolean tab, boolean enter, boolean asEvents) throws RemoteException {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setOutputType(overwrite ? OutputTypeEnum.DirectFillWithReplace : OutputTypeEnum.DirectFill);
        configuration.setAddTab(tab);
        configuration.setAddReturn(enter);
        configuration.setAsEvents(asEvents);
    }

    public void disabled() throws RemoteException {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setOutputType(OutputTypeEnum.Disabled);
    }
}
