package dev.duma.android.sunmi.scanconfigurationhelper;

import android.os.RemoteException;

import java.util.EnumSet;

import dev.duma.android.sunmi.scanconfigurationhelper.config.CodeFamiliesConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.config.ServiceConfiguration;
import dev.duma.android.sunmi.scanconfigurationhelper.enums.WriteContextTypeEnum;

public class ConfigurationWriteContextHelper implements IConfigurationWriteContextHelper {
    private final IScanConfigurationHelper scanConfigurationHelper;

    private ServiceConfiguration serviceWriteContext;
    private CodeFamiliesConfiguration codeFamiliesWriteContext;
    private EnumSet<WriteContextTypeEnum> types = EnumSet.noneOf(WriteContextTypeEnum.class);

    public ConfigurationWriteContextHelper(IScanConfigurationHelper scanConfigurationHelper) {
        this.scanConfigurationHelper = scanConfigurationHelper;
    }

    @Override
    public void createWriteContext(IContextCreated callback, WriteContextTypeEnum type) throws RemoteException {
        createWriteContext(callback, EnumSet.of(type));
    }

    @Override
    public void createWriteContext(IContextCreated callback, EnumSet<WriteContextTypeEnum> types) throws RemoteException {
        if(hasWriteContextOfAnyType()) discardWriteContext();

        this.types = types;

        if(types.contains(WriteContextTypeEnum.Service) && types.contains(WriteContextTypeEnum.CodeFamilies)) {
            scanConfigurationHelper.loadServiceConfig(serviceConfiguration -> {
                this.serviceWriteContext = serviceConfiguration;
                scanConfigurationHelper.loadCodeFamiliesConfig(codeFamiliesConfiguration -> {
                    this.codeFamiliesWriteContext = codeFamiliesConfiguration;
                    callback.onCreated(serviceWriteContext, codeFamiliesWriteContext);
                });
            });
        } else if(types.contains(WriteContextTypeEnum.Service) && !types.contains(WriteContextTypeEnum.CodeFamilies)) {
            scanConfigurationHelper.loadServiceConfig(serviceConfiguration -> {
                this.serviceWriteContext = serviceConfiguration;
                callback.onCreated(serviceWriteContext, null);
            });
        } else if(!types.contains(WriteContextTypeEnum.Service) && types.contains(WriteContextTypeEnum.CodeFamilies)) {
            scanConfigurationHelper.loadCodeFamiliesConfig(codeFamiliesConfiguration -> {
                this.codeFamiliesWriteContext = codeFamiliesConfiguration;
                callback.onCreated(null, codeFamiliesWriteContext);
            });
        }
    }

    @Override
    public void commitWriteContext() throws RemoteException {
        if(!hasWriteContextOfAnyType())
            throw new RuntimeException("No opened write context has been found!");

        if(types.contains(WriteContextTypeEnum.Service)) {
            scanConfigurationHelper.persistServiceConfig(this.serviceWriteContext);
        }

        if(types.contains(WriteContextTypeEnum.CodeFamilies)) {
            scanConfigurationHelper.persistCodeFamiliesConfig(this.codeFamiliesWriteContext);
        }

        discardWriteContext();
    }

    @Override
    public void discardWriteContext() {
        if(types.contains(WriteContextTypeEnum.Service)) {
            this.serviceWriteContext = null;
        }

        if(types.contains(WriteContextTypeEnum.CodeFamilies)) {
            this.codeFamiliesWriteContext = null;
        }
    }

    @Override
    public boolean hasWriteContextOfAnyType() {
        return hasWriteContextOf(WriteContextTypeEnum.Service) || hasWriteContextOf(WriteContextTypeEnum.CodeFamilies);
    }

    @Override
    public boolean hasWriteContextOf(WriteContextTypeEnum type) {
        if(types.contains(WriteContextTypeEnum.Service)) {
            return this.serviceWriteContext != null;
        }

        if(types.contains(WriteContextTypeEnum.CodeFamilies)) {
            return this.codeFamiliesWriteContext != null;
        }

        return false;
    }

    @Override
    public ServiceConfiguration getServiceWriteContext() {
        if(!hasWriteContextOf(WriteContextTypeEnum.Service)) throw new RuntimeException("No opened Service write context has been found!");

        return serviceWriteContext;
    }

    @Override
    public CodeFamiliesConfiguration getCodeFamiliesWriteContext() {
        if(!hasWriteContextOf(WriteContextTypeEnum.CodeFamilies)) throw new RuntimeException("No opened CodeFamilies write context has been found!");

        return codeFamiliesWriteContext;
    }
}
