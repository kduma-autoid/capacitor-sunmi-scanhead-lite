package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum ScanResultCodeIDEnum {
    None(0),
    SunmiId(1),
    AimId(2),
    SymbolId(3);

    private final int value;
    private static final Map<Integer, ScanResultCodeIDEnum> map = new HashMap<>();

    ScanResultCodeIDEnum(int value) {
        this.value = value;
    }

    static {
        for (ScanResultCodeIDEnum pageType : ScanResultCodeIDEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static ScanResultCodeIDEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no ScanResultCodeIDEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
