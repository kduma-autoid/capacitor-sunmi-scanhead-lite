package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;

import dev.duma.android.sunmi.scanconfigurationhelper.IScanConfigurationHelper;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ScanResultCodeIDEnum;

public class CodeTypeConfigurator {
    private final IScanConfigurationHelper scanConfigurationHelper;

    public CodeTypeConfigurator(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    public void returnCodeType(boolean enabled) throws RemoteException {
        scanConfigurationHelper.loadServiceConfig((configuration) -> {
            configuration.setScanResultCodeID(enabled ? ScanResultCodeIDEnum.SunmiId : ScanResultCodeIDEnum.None);

            scanConfigurationHelper.persistServiceConfig(configuration);
        });
    }
}
