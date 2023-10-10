package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum TriggerMethodEnum {
    Trigger(0),
    Continuous(1),
    Pulse(2),
    LongPress(3);

    private final int value;
    private static final Map<Integer, TriggerMethodEnum> map = new HashMap<>();

    TriggerMethodEnum(int value) {
        this.value = value;
    }

    static {
        for (TriggerMethodEnum pageType : TriggerMethodEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static TriggerMethodEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no TriggerMethodEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
