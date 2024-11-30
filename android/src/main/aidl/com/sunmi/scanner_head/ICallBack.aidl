package com.sunmi.scanner_head;

import com.sunmi.scanner_head.entity.Entity;
import com.sunmi.scanner_head.entity.ServiceSetting;

interface ICallBack {
    oneway void onSuccess(in Entity entity);

    oneway void onFiled(int i);
}
