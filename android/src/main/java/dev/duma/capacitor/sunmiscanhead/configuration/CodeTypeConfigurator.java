package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IConfigurationWriteContextHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ScanResultCodeIDEnum;

public class CodeTypeConfigurator {
    private final IConfigurationWriteContextHelper configurationWriteContextHelper;

    public CodeTypeConfigurator(IConfigurationWriteContextHelper configurationWriteContextHelper) {
        this.configurationWriteContextHelper = configurationWriteContextHelper;
    }

    public void returnCodeType(boolean enabled) {
        ServiceConfiguration configuration = configurationWriteContextHelper.getWriteContext();

        configuration.setScanResultCodeID(enabled ? ScanResultCodeIDEnum.SunmiId : ScanResultCodeIDEnum.None);
    }
}
