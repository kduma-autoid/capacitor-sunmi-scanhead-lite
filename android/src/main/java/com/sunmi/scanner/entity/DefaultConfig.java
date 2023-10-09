package com.sunmi.scanner.entity;

import java.util.List;

public class DefaultConfig {
    public List<CodeSets> allCode;
    public ServiceSetting serviceSetting;

    public String toString() {
        return "DefaultConfig{serviceSetting=" + this.serviceSetting + ", allCode=" + this.allCode + '}';
    }
}
