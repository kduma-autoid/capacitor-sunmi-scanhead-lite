package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum OutputTypeEnum {
    DirectFill(0),
    DirectFillWithReplace(1),
    Keystroke(2),
    Disabled(3);

    private final int value;
    private static final Map<Integer, OutputTypeEnum> map = new HashMap<>();

    OutputTypeEnum(int value) {
        this.value = value;
    }

    static {
        for (OutputTypeEnum pageType : OutputTypeEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static OutputTypeEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no OutputTypeEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
