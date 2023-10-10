package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum ScanResultCodeIDEnum {
    None(0, "none"),
    SunmiId(1, "sunmi-id"),
    AimId(2, "aim-id"),
    SymbolId(3, "symbol-id");

    private final int value;
    private final String name;
    private static final Map<Integer, ScanResultCodeIDEnum> map = new HashMap<>();
    private static final Map<String, ScanResultCodeIDEnum> map_names = new HashMap<>();

    ScanResultCodeIDEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (ScanResultCodeIDEnum pageType : ScanResultCodeIDEnum.values()) {
            map.put(pageType.value, pageType);
        }
        for (ScanResultCodeIDEnum pageType : ScanResultCodeIDEnum.values()) {
            map_names.put(pageType.name, pageType);
        }
    }

    public static ScanResultCodeIDEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no ScanResultCodeIDEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static ScanResultCodeIDEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no ScanResultCodeIDEnum for name of: "+name);
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
