package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum CenterDecodingSettingEnum {
    Disabled(0),
    CenterOnly(1),
    CenterFirst(2);

    private final int value;
    private static final Map<Integer, CenterDecodingSettingEnum> map = new HashMap<>();

    CenterDecodingSettingEnum(int value) {
        this.value = value;
    }

    static {
        for (CenterDecodingSettingEnum pageType : CenterDecodingSettingEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static CenterDecodingSettingEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no CenterDecodingSettingEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
