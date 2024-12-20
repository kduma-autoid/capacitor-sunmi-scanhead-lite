package dev.duma.android.sunmi.scanconfigurationhelper.config;

import android.util.ArrayMap;
import android.util.Log;

import com.sunmi.scanner.config.SunmiHelper;
import com.sunmi.scanner.entity.CodeEnable;
import com.sunmi.scanner.entity.CodeSetting;

import java.util.ArrayList;
import java.util.Objects;

import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CodeFamilyConfigurationFieldEnum;

public class CodeFamiliesConfigurationConverter {
    public static CodeFamiliesConfiguration fromCodeEnable(CodeEnable codeEnable, ArrayMap<String, CodeSetting> settings) {
        CodeFamiliesConfiguration configuration = new CodeFamiliesConfiguration();

        for (int i = 0; i < codeEnable.getCodes().length; i++) {
            configuration.enabledCodes.put(
                    codeEnable.getCodes()[i],
                    codeEnable.getEnable()[i]
            );
        }

        for (String name: settings.keySet()) {
            CodeSetting setting = settings.get(name);

            configuration.symbolConfig.put(
                    name,
                    fromCodeSetting(
                            Objects.requireNonNull(setting)
                    )
            );
        }

        return configuration;
    }

    protected static CodeFamilySettingsConfiguration fromCodeSetting(CodeSetting setting) {
        CodeFamilySettingsConfiguration configuration = new CodeFamilySettingsConfiguration();

        if(setting.getCheckCharMode() != -1) {
            configuration.checkCharMode = setting.getCheckCharMode();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.CheckCharMode);
        }

        if(setting.getCheckCharType() != -1) {
            configuration.checkCharType = setting.getCheckCharType();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.CheckCharType);
        }

        if(setting.getDoubleCode() != -1) {
            configuration.doubleCode = setting.getDoubleCode();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.DoubleCode);
        }

        if(setting.getFormatCode() != -1) {
            configuration.formatCode = setting.getFormatCode();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.FormatCode);
        }

        if(setting.getInverseCode() != -1) {
            configuration.inverseCode = setting.getInverseCode();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.InverseCode);
        }

//        if(setting.isExtendCode1() != -1) {
            configuration.isExtendCode1 = setting.isExtendCode1();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendCode1);
//        }

//        if(setting.isExtendCode2() != -1) {
            configuration.isExtendCode2 = setting.isExtendCode2();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendCode2);
//        }

//        if(setting.isExtendToCode() != -1) {
            configuration.isExtendToCode = setting.isExtendToCode();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendToCode);
//        }

//        if(setting.isMicroCode() != -1) {
            configuration.isMicroCode = setting.isMicroCode();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsMicroCode);
//        }

//        if(setting.isStartEndType() != -1) {
            configuration.isStartEndType = setting.isStartEndType();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsStartEndType);
//        }

//        if(setting.isSystemCharZero() != -1) {
            configuration.isSystemCharZero = setting.isSystemCharZero();
//        } else {
//            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.IsSystemCharZero);
//        }

        if(setting.getMaxLen() != -1) {
            configuration.maxLen = setting.getMaxLen();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.MaxLen);
        }

        if(setting.getMinLen() != -1) {
            configuration.minLen = setting.getMinLen();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.MinLen);
        }

        if(setting.getStartEndFormat() != -1) {
            configuration.startEndFormat = setting.getStartEndFormat();
        } else {
            configuration.unsupportedFields.add(CodeFamilyConfigurationFieldEnum.StartEndFormat);
        }

        return configuration;
    }


    public static ArrayList<String> toConfigurationCommands(CodeFamiliesConfiguration configuration) {
        ArrayList<String> commands = new ArrayList<>();

        for (String code : configuration.updatedEnabledCodes) {
            String cmd = SunmiHelper.setCodeEnable(code, Boolean.TRUE.equals(configuration.enabledCodes.get(code)));
            if(cmd != null && !cmd.equals("")) {
                commands.add(cmd);
            } else {
                Log.e("CodeFamilies", "Command not found for code="+ code);
            }
        }

        for (String code : configuration.symbolConfig.keySet()) {
            CodeFamilySettingsConfiguration setting = configuration.symbolConfig.get(code);

            assert setting != null;
            if (!setting.isUpdated())
                continue;

            if (
                    (setting.isSupported(CodeFamilyConfigurationFieldEnum.MinLen) && setting.isSupported(CodeFamilyConfigurationFieldEnum.MaxLen))
                            && (setting.isUpdated(CodeFamilyConfigurationFieldEnum.MinLen) || setting.isUpdated(CodeFamilyConfigurationFieldEnum.MaxLen))
            ) {
                // setting.minLen >= codesRules.minLen && setting.minLen <= codesRules.maxLen
                // && setting.maxLen >= codesRules.minLen && setting.maxLen <= codesRules.maxLen
                commands.add(SunmiHelper.setCodeReadRange(code, new int[]{setting.minLen, setting.maxLen}));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.CheckCharType) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.CheckCharType)) {
                // codesRules.checkCharType.length > 0
                commands.add(SunmiHelper.setCodeCheckCharType(code, setting.getCheckCharType()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsStartEndType) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsStartEndType)) {
                // codesRules.startEndType != -1
                commands.add(SunmiHelper.setCodeStartEndType(code, setting.isStartEndType()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.StartEndFormat) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.StartEndFormat)) {
                // codesRules.startEndType == 1
                commands.add(SunmiHelper.setCodeStartEndFormat(code, setting.getStartEndFormat()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsExtendCode1) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsExtendCode1)) {
                // codesRules.extendCode1Type != -1
                commands.add(SunmiHelper.setCodeExtendRead1(code, setting.isExtendCode1()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsExtendCode2) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsExtendCode2)) {
                // codesRules.extendCode2Type != -1
                commands.add(SunmiHelper.setCodeExtendRead2(code, setting.isExtendCode2()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsSystemCharZero) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsSystemCharZero)) {
                // codesRules.systemCharZero != -1
                commands.add(SunmiHelper.setCodeSystemCharZero(code, setting.isSystemCharZero()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsExtendToCode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsExtendToCode)) {
                // codesRules.extendToCode != -1
                commands.add(SunmiHelper.setCodeExtendToCode(code, setting.isExtendToCode()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.CheckCharMode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.CheckCharMode)) {
                // codesRules.checkCharMode.length > 0
                commands.add(SunmiHelper.setCodeCheckMode(code, setting.getCheckCharMode()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.DoubleCode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.DoubleCode)) {
                // codesRules.doubleCode != -1
                commands.add(SunmiHelper.setCodeReadDouble(code, setting.getDoubleCode()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.IsMicroCode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.IsMicroCode)) {
                // codesRules.microCode != -1
                commands.add(SunmiHelper.setCodeReadMicro(code, setting.isMicroCode()));
            }

            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.InverseCode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.InverseCode)) {
                // codesRules.inverseCode != -1
                commands.add(SunmiHelper.setCodeReadInverse(code, setting.getInverseCode()));
            }
            if (setting.isSupported(CodeFamilyConfigurationFieldEnum.FormatCode) && setting.isUpdated(CodeFamilyConfigurationFieldEnum.FormatCode)) {
                // codesRules.formatMode != -1
                commands.add(SunmiHelper.setCodeFormatMode(code, setting.getFormatCode()));
            }
        }

        return commands;
    }
}
