// IScanInterface.aidl
package com.sunmi.scanner_head;

import com.sunmi.scanner_head.ICallBack;

interface IScanInterface {
     /**
     * #1
     * 触发开始与停止扫码
     * key.getAction()==KeyEvent.ACTION_UP 触发开始扫码
     * key.getAction()==KeyEvent.ACTION_DWON 触发停止扫码
     */
    void sendKeyEvent(in KeyEvent key) = 0;

    /**
    * #2
     * 触发开始扫码
     */
    void scan() = 1;

    /**
     * 触发停止扫码
     */
    void stop() = 2;

    /**
     * 获取扫码头类型
     * 100-->NONE
     * 101-->P2Lite
     * 102-->l2-newland
     * 103-->l2-zabra
     */
    int getScannerModel() = 3;

    void sendCommand(String str) = 5;

    void sendQuery(String str, in ICallBack iCallBack) = 6;

    boolean clearConfig() = 7;
}
