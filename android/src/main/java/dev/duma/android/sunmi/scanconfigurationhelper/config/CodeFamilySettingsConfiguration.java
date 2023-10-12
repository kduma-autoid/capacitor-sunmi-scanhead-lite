package dev.duma.android.sunmi.scanconfigurationhelper.config;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CodeFamilyConfigurationFieldEnum;

public class CodeFamilySettingsConfiguration {
    protected final EnumSet<CodeFamilyConfigurationFieldEnum> updatedFields = EnumSet.noneOf(CodeFamilyConfigurationFieldEnum.class);
    protected final EnumSet<CodeFamilyConfigurationFieldEnum> unsupportedFields = EnumSet.noneOf(CodeFamilyConfigurationFieldEnum.class);

    public boolean isUpdated() {
        return ! this.updatedFields.isEmpty();
    }

    public boolean isUpdated(CodeFamilyConfigurationFieldEnum field) {
        return this.updatedFields.contains(field);
    }

    public boolean isSupported(CodeFamilyConfigurationFieldEnum field) {
        return !this.unsupportedFields.contains(field);
    }

    protected int checkCharMode = -1;
    protected int checkCharType = -1;
    protected int doubleCode = -1;
    protected int formatCode = -1;
    protected int inverseCode = -1;
    protected boolean isExtendCode1;
    protected boolean isExtendCode2;
    protected boolean isExtendToCode;
    protected boolean isMicroCode;
    protected boolean isStartEndType;
    protected boolean isSystemCharZero;
    protected int maxLen = -1;
    protected int minLen = -1;
    protected int startEndFormat = -1;

    public int getCheckCharMode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharMode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.CheckCharMode+" is not supported with this code family!");
        }

        return checkCharMode;
    }

    public void setCheckCharMode(int checkCharMode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharMode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.CheckCharMode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharMode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.CheckCharMode);
        }

        this.checkCharMode = checkCharMode;
    }

    public int getCheckCharType() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharType)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.CheckCharType+" is not supported with this code family!");
        }

        return checkCharType;
    }

    public void setCheckCharType(int checkCharType) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharType)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.CheckCharType+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.CheckCharType)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.CheckCharType);
        }

        this.checkCharType = checkCharType;
    }

    public int getDoubleCode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.DoubleCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.DoubleCode+" is not supported with this code family!");
        }

        return doubleCode;
    }

    public void setDoubleCode(int doubleCode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.DoubleCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.DoubleCode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.DoubleCode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.DoubleCode);
        }

        this.doubleCode = doubleCode;
    }

    public int getFormatCode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.FormatCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.FormatCode+" is not supported with this code family!");
        }

        return formatCode;
    }

    public void setFormatCode(int formatCode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.FormatCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.FormatCode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.FormatCode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.FormatCode);
        }

        this.formatCode = formatCode;
    }

    public int getInverseCode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.InverseCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.InverseCode+" is not supported with this code family!");
        }

        return inverseCode;
    }

    public void setInverseCode(int inverseCode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.InverseCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.InverseCode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.InverseCode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.InverseCode);
        }

        this.inverseCode = inverseCode;
    }

    public boolean isExtendCode1() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode1)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendCode1+" is not supported with this code family!");
        }

        return isExtendCode1;
    }

    public void setExtendCode1(boolean extendCode1) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode1)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendCode1+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode1)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendCode1);
        }

        isExtendCode1 = extendCode1;
    }

    public boolean isExtendCode2() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode2)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendCode2+" is not supported with this code family!");
        }

        return isExtendCode2;
    }

    public void setExtendCode2(boolean extendCode2) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode2)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendCode2+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendCode2)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendCode2);
        }

        isExtendCode2 = extendCode2;
    }

    public boolean isExtendToCode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendToCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendToCode+" is not supported with this code family!");
        }

        return isExtendToCode;
    }

    public void setExtendToCode(boolean extendToCode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendToCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsExtendToCode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsExtendToCode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsExtendToCode);
        }

        isExtendToCode = extendToCode;
    }

    public boolean isMicroCode() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsMicroCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsMicroCode+" is not supported with this code family!");
        }

        return isMicroCode;
    }

    public void setMicroCode(boolean microCode) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsMicroCode)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsMicroCode+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsMicroCode)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsMicroCode);
        }

        isMicroCode = microCode;
    }

    public boolean isStartEndType() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsStartEndType)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsStartEndType+" is not supported with this code family!");
        }

        return isStartEndType;
    }

    public void setStartEndType(boolean startEndType) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsStartEndType)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsStartEndType+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsStartEndType)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsStartEndType);
        }

        isStartEndType = startEndType;
    }

    public boolean isSystemCharZero() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsSystemCharZero)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsSystemCharZero+" is not supported with this code family!");
        }

        return isSystemCharZero;
    }

    public void setSystemCharZero(boolean systemCharZero) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.IsSystemCharZero)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.IsSystemCharZero+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.IsSystemCharZero)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.IsSystemCharZero);
        }

        isSystemCharZero = systemCharZero;
    }

    public int getMaxLen() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.MaxLen)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.MaxLen+" is not supported with this code family!");
        }

        return maxLen;
    }

    public void setMaxLen(int maxLen) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.MaxLen)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.MaxLen+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.MaxLen)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.MaxLen);
        }

        this.maxLen = maxLen;
    }

    public int getMinLen() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.MinLen)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.MinLen+" is not supported with this code family!");
        }

        return minLen;
    }

    public void setMinLen(int minLen) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.MinLen)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.MinLen+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.MinLen)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.MinLen);
        }

        this.minLen = minLen;
    }

    public int getStartEndFormat() {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.StartEndFormat)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.StartEndFormat+" is not supported with this code family!");
        }

        return startEndFormat;
    }

    public void setStartEndFormat(int startEndFormat) {
        if(this.unsupportedFields.contains(CodeFamilyConfigurationFieldEnum.StartEndFormat)) {
            throw new RuntimeException("Field "+CodeFamilyConfigurationFieldEnum.StartEndFormat+" is not supported with this code family!");
        }

        if(!this.updatedFields.contains(CodeFamilyConfigurationFieldEnum.StartEndFormat)) {
            this.updatedFields.add(CodeFamilyConfigurationFieldEnum.StartEndFormat);
        }

        this.startEndFormat = startEndFormat;
    }
}
