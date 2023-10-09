package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.models.ScanResultCodeIDEnum;

public class CodeTypeConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public CodeTypeConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void returnCodeType(boolean enabled) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration, response) -> {
            configuration.setScanResultCodeID(enabled ? ScanResultCodeIDEnum.SunmiId : ScanResultCodeIDEnum.None);

            scanConfigurationHelper.persistServiceConfig(configuration, response);
        });
    }
}
