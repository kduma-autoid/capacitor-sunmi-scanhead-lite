package dev.duma.android.sunmi.scanconfigurationhelper.config;

import java.util.HashMap;
import java.util.HashSet;

public class CodeFamiliesConfiguration {
    HashSet<String> updatedEnabledCodes = new HashSet<>();
    HashMap<String, Boolean> enabledCodes = new HashMap<>();
    HashMap<String, CodeFamilySettingsConfiguration> symbolConfig = new HashMap<>();

    public void setCodeStatus(String code, boolean enabled) {
        if(!enabledCodes.containsKey(code)) {
            throw new RuntimeException("Code "+code+" was not found!");
        }

        enabledCodes.put(code, enabled);
        updatedEnabledCodes.add(code);
    }

    public boolean getCodeStatus(String code) {
        if(!enabledCodes.containsKey(code)) {
            throw new RuntimeException("Code "+code+" was not found!");
        }

        return Boolean.TRUE.equals(enabledCodes.get(code));
    }

    public CodeFamilySettingsConfiguration getCodeConfiguration(String code) {
        if(!symbolConfig.containsKey(code)) {
            throw new RuntimeException("Code "+code+" was not found!");
        }

        return symbolConfig.get(code);
    }

//    public HashMap<String, Boolean> getEnabledCodes() {
//        return (HashMap<String, Boolean>) enabledCodes.clone();
//    }
}
