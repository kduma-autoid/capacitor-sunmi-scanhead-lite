package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum SpecificSceneEnum {
    Default(0),
    ReflectiveDMbarcode(1),
    ReflectiveQRDMbarcode(2),
    SpecialColourBarcode(3),
    DpmBarcode(4),
    MobileScreenScene(5);

    private final int value;
    private static final Map<Integer, SpecificSceneEnum> map = new HashMap<>();

    SpecificSceneEnum(int value) {
        this.value = value;
    }

    static {
        for (SpecificSceneEnum pageType : SpecificSceneEnum.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public static SpecificSceneEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no SpecificSceneEnum for value of: "+value);
        }

        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
