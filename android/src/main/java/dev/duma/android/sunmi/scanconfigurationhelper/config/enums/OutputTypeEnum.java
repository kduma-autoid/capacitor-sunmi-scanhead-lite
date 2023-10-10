package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutputTypeEnum {
    DirectFill(0, "direct-fill"),
    DirectFillWithReplace(1, "direct-fill-with-replace"),
    Keystroke(2, "keystroke"),
    Disabled(3, "disabled");

    private final int value;
    private final String name;
    private static final Map<Integer, OutputTypeEnum> map = new HashMap<>();
    private static final Map<String, OutputTypeEnum> map_names = new HashMap<>();

    OutputTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (OutputTypeEnum pageType : OutputTypeEnum.values()) {
            map.put(pageType.value, pageType);
        }
        for (OutputTypeEnum pageType : OutputTypeEnum.values()) {
            map_names.put(pageType.name, pageType);
        }
    }

    public static OutputTypeEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no OutputTypeEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static OutputTypeEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no OutputTypeEnum for name of: "+name);
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
