package dev.duma.capacitor.sunmiscanhead.configuration;

import android.os.RemoteException;
import android.util.Log;

import com.sunmi.scanner.ICallBack;
import com.sunmi.scanner.entity.Entity;
import com.sunmi.scanner.entity.ServiceSetting;

public class SunmiCallback extends ICallBack.Stub implements ICallBack {
    @Override
    public void onSuccess(Entity entity) throws RemoteException {
        ServiceSetting bean = (ServiceSetting) entity.getBean();
        Log.i("SunmiCallback", "onSuccess="+entity.toString());
        Log.i("SunmiCallback", "bean="+bean.toString());
    }

    @Override
    public void onFiled(int i) throws RemoteException {
        Log.i("SunmiCallback", "onFiled="+i);
    }
}
