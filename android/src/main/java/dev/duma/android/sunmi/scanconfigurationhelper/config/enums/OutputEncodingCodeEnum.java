package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutputEncodingCodeEnum {
    UTF8(0, "UTF8"),
    GBK(1, "GBK"),
    ISO88591(2, "ISO88591"),
    SHIFTJIS(3, "SHIFTJIS"),
    Auto(4, "Auto"),
    WINDOWS1256(5, "WINDOWS1256"),
    WINDOWS874(6, "WINDOWS874"),
    Unicode(7, "Unicode"),
    Big5(8, "Big5"),
    ASCII(9, "ASCII"),
    GB2312(10, "GB2312"),
    GB18030(11, "GB18030");

    private final int value;
    private final String name;
    private static final Map<Integer, OutputEncodingCodeEnum> map = new HashMap<>();
    private static final Map<String, OutputEncodingCodeEnum> map_names = new HashMap<>();

    OutputEncodingCodeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (OutputEncodingCodeEnum e : OutputEncodingCodeEnum.values()) {
            map.put(e.value, e);
        }
        for (OutputEncodingCodeEnum e : OutputEncodingCodeEnum.values()) {
            map_names.put(e.name, e);
        }
    }

    public static OutputEncodingCodeEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no OutputEncodingCodeEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static OutputEncodingCodeEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no OutputEncodingCodeEnum for name of: "+name);
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
