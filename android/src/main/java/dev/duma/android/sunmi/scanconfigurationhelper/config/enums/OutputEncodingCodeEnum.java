package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutputEncodingCodeEnum {
    UTF8(0),
    GBK(1),
    ISO88591(2),
    SHIFTJIS(3),
    Auto(4),
    WINDOWS1256(5),
    WINDOWS874(6),
    Unicode(7),
    Big5(8),
    ASCII(9),
    GB2312(10),
    GB18030(11);

    private final int value;
    private static final Map<Integer, OutputEncodingCodeEnum> map = new HashMap<>();

    OutputEncodingCodeEnum(int value) {
        this.value = value;
    }

    static {
        for (OutputEncodingCodeEnum pageType : OutputEncodingCodeEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static OutputEncodingCodeEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no OutputEncodingCodeEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
