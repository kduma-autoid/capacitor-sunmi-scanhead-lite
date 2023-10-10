package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum CenterDecodingSettingEnum {
    Disabled(0, "disabled"),
    CenterOnly(1, "center-only"),
    CenterFirst(2, "center-first");

    private final int value;
    private final String name;
    private static final Map<Integer, CenterDecodingSettingEnum> map = new HashMap<>();
    private static final Map<String, CenterDecodingSettingEnum> map_names = new HashMap<>();

    CenterDecodingSettingEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (CenterDecodingSettingEnum e : CenterDecodingSettingEnum.values()) {
            map.put(e.value, e);
        }
        for (CenterDecodingSettingEnum e : CenterDecodingSettingEnum.values()) {
            map_names.put(e.name, e);
        }
    }

    public static CenterDecodingSettingEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no CenterDecodingSettingEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static CenterDecodingSettingEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no CenterDecodingSettingEnum for name of: "+name);
        }

        return map_names.get(name);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
