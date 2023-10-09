package dev.duma.capacitor.sunmiscanhead.configuration;

import android.content.Context;
import android.os.RemoteException;

import com.sunmi.scanner.IScanInterface;

import dev.duma.capacitor.sunmiscanhead.SunmiScanHead;
import dev.duma.capacitor.sunmiscanhead.SunmiHelper;

public class CodeTypeConfigurator {
    private Context context;
    private SunmiScanHead SunmiScanHead;

    public CodeTypeConfigurator(Context context, SunmiScanHead SunmiScanHead) {
        this.context = context;
        this.SunmiScanHead = SunmiScanHead;
    }

    public void returnCodeType() throws RemoteException {
        returnCodeType(true);
    }

    public void returnCodeType(boolean enabled) throws RemoteException {
        SunmiScanHead.getScanInterfaceHelper().sendCommand(
            SunmiHelper.createCmd(SunmiHelper.SET_OUT_CODE_ID, enabled ? 1 : 0)
        );
    }
}
