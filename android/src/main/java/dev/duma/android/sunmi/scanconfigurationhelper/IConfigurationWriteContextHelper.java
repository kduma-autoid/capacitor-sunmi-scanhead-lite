package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;

import java.util.EnumSet;

import dev.duma.android.sunmi.scanconfigurationhelper.config.CodeFamiliesConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.enums.WriteContextTypeEnum;

public interface IConfigurationWriteContextHelper {
    interface IContextCreated {
        void onCreated(ServiceConfiguration service, CodeFamiliesConfiguration codeFamilies) throws RemoteException;
    }

    void createWriteContext(IContextCreated callback, WriteContextTypeEnum type) throws RemoteException;
    void createWriteContext(IContextCreated callback, EnumSet<WriteContextTypeEnum> types) throws RemoteException;
    void commitWriteContext() throws RemoteException;
    void discardWriteContext();
    boolean hasWriteContextOfAnyType();
    boolean hasWriteContextOf(WriteContextTypeEnum type);
    ServiceConfiguration getServiceWriteContext();
    CodeFamiliesConfiguration getCodeFamiliesWriteContext();

    class Factory
    {
        static public IConfigurationWriteContextHelper make(IScanConfigurationHelper scanConfigurationHelper) {
            return new ConfigurationWriteContextHelper(scanConfigurationHelper);
        }
    }
}
