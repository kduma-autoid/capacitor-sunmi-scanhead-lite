package dev.duma.android.sunmi.scanconfigurationhelper.enums;

import java.util.HashMap;
import java.util.Map;

import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CenterDecodingSettingEnum;

public enum WriteContextTypeEnum {
    Service("service"),
    CodeFamilies("decoders");

    private final String name;
    private static final Map<String, WriteContextTypeEnum> map = new HashMap<>();

    WriteContextTypeEnum(String name) {
        this.name = name;
    }

    static {
        for (WriteContextTypeEnum e : WriteContextTypeEnum.values()) {
            map.put(e.name, e);
        }
    }

    public static WriteContextTypeEnum nameOf(String name) {
        if(! map.containsKey(name)) {
            throw new RuntimeException("There is no WriteContextTypeEnum for name of: "+name);
        }

        return map.get(name);
    }

    public String getName() {
        return name;
    }
}
