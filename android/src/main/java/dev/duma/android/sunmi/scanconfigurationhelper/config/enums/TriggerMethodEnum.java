package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum TriggerMethodEnum {
    Trigger(0, "trigger"),
    Continuous(1, "continuous"),
    Pulse(2, "pulse"),
    LongPress(3, "long-press");

    private final int value;
    private final String name;
    private static final Map<Integer, TriggerMethodEnum> map = new HashMap<>();
    private static final Map<String, TriggerMethodEnum> map_names = new HashMap<>();

    TriggerMethodEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (TriggerMethodEnum pageType : TriggerMethodEnum.values()) {
            map.put(pageType.value, pageType);
        }
        for (TriggerMethodEnum pageType : TriggerMethodEnum.values()) {
            map_names.put(pageType.name, pageType);
        }
    }

    public static TriggerMethodEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no TriggerMethodEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static TriggerMethodEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no TriggerMethodEnum for name of: "+name);
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
