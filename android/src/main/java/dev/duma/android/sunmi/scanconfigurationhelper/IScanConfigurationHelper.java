package dev.duma.android.sunmi.scanconfigurationhelper;

import android.content.Context;
import android.os.RemoteException;

import dev.duma.android.sunmi.scaninterfacehelper.IScanInterfaceHelper;
import dev.duma.android.sunmi.scaninterfacehelper.ScanInterfaceHelper;

public interface IScanConfigurationHelper {
    void loadConfig() throws RemoteException;

    class Factory
    {
        static public IScanConfigurationHelper make(IScanInterfaceHelper scanInterfaceHelper) {
            return new ScanConfigurationHelper(scanInterfaceHelper);
        }
    }
}
