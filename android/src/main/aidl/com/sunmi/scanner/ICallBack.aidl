package com.sunmi.scanner;

import com.sunmi.scanner.entity.Entity;
import com.sunmi.scanner.entity.ServiceSetting;

interface ICallBack {
    oneway void onSuccess(in Entity entity);

    oneway void onFiled(int i);
}
