package dev.duma.android.sunmi.scanconfigurationhelper.config.enums;

import java.util.HashMap;
import java.util.Map;

public enum SpecificSceneEnum {
    Default(0, "default"),
    ReflectiveDMBarcode(1, "reflective-dm-barcode"),
    ReflectiveQRDMBarcode(2, "reflective-qr-dm-barcode"),
    SpecialColourBarcode(3, "special-colour-barcode"),
    DpmBarcode(4, "dpm-barcode"),
    MobileScreenScene(5, "mobile-screen-scene");

    private final int value;
    private final String name;
    private static final Map<Integer, SpecificSceneEnum> map = new HashMap<>();
    private static final Map<String, SpecificSceneEnum> map_names = new HashMap<>();

    SpecificSceneEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    static {
        for (SpecificSceneEnum e : SpecificSceneEnum.values()) {
            map.put(e.value, e);
        }
        for (SpecificSceneEnum e : SpecificSceneEnum.values()) {
            map_names.put(e.name, e);
        }
    }

    public static SpecificSceneEnum valueOf(int value) {
        if(! map.containsKey(value)) {
            throw new RuntimeException("There is no SpecificSceneEnum for value of: "+value);
        }

        return map.get(value);
    }

    public static SpecificSceneEnum nameOf(String name) {
        if(! map_names.containsKey(name)) {
            throw new RuntimeException("There is no SpecificSceneEnum for name of: "+name);
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
