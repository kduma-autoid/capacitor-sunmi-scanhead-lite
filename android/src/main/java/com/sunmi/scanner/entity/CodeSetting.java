package com.sunmi.scanner.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class CodeSetting implements Parcelable {
    public static final Parcelable.Creator<CodeSetting> CREATOR = new Parcelable.Creator<CodeSetting>() {
        public CodeSetting createFromParcel(Parcel parcel) {
            return new CodeSetting(parcel);
        }

        public CodeSetting[] newArray(int i) {
            return new CodeSetting[i];
        }
    };
    public int checkCharMode = -1;
    public int checkCharType = -1;
    public int doubleCode = -1;
    public int formatCode = -1;
    public int inverseCode = -1;
    public boolean isExtendCode1;
    public boolean isExtendCode2;
    public boolean isExtendToCode;
    public boolean isMicroCode;
    public boolean isStartEndType;
    public boolean isSystemCharZero;
    public int maxLen = -1;
    public int minLen = -1;
    public int startEndFormat = -1;

    public int describeContents() {
        return 0;
    }

    public CodeSetting() {
    }

    protected CodeSetting(Parcel parcel) {
        this.minLen = parcel.readInt();
        this.maxLen = parcel.readInt();
        this.checkCharType = parcel.readInt();
        boolean z = true;
        this.isStartEndType = parcel.readByte() != 0;
        this.startEndFormat = parcel.readInt();
        this.isExtendCode1 = parcel.readByte() != 0;
        this.isExtendCode2 = parcel.readByte() != 0;
        this.isSystemCharZero = parcel.readByte() != 0;
        this.isExtendToCode = parcel.readByte() != 0;
        this.checkCharMode = parcel.readInt();
        this.doubleCode = parcel.readInt();
        this.isMicroCode = parcel.readByte() == 0 ? false : z;
        this.inverseCode = parcel.readInt();
        this.formatCode = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.minLen);
        parcel.writeInt(this.maxLen);
        parcel.writeInt(this.checkCharType);
        parcel.writeByte(this.isStartEndType ? (byte) 1 : 0);
        parcel.writeInt(this.startEndFormat);
        parcel.writeByte(this.isExtendCode1 ? (byte) 1 : 0);
        parcel.writeByte(this.isExtendCode2 ? (byte) 1 : 0);
        parcel.writeByte(this.isSystemCharZero ? (byte) 1 : 0);
        parcel.writeByte(this.isExtendToCode ? (byte) 1 : 0);
        parcel.writeInt(this.checkCharMode);
        parcel.writeInt(this.doubleCode);
        parcel.writeByte(this.isMicroCode ? (byte) 1 : 0);
        parcel.writeInt(this.inverseCode);
        parcel.writeInt(this.formatCode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CodeSetting codeSetting = (CodeSetting) obj;
        if (this.minLen == codeSetting.minLen && this.maxLen == codeSetting.maxLen && this.checkCharType == codeSetting.checkCharType && this.isStartEndType == codeSetting.isStartEndType && this.startEndFormat == codeSetting.startEndFormat && this.isExtendCode1 == codeSetting.isExtendCode1 && this.isExtendCode2 == codeSetting.isExtendCode2 && this.isSystemCharZero == codeSetting.isSystemCharZero && this.isExtendToCode == codeSetting.isExtendToCode && this.checkCharMode == codeSetting.checkCharMode && this.doubleCode == codeSetting.doubleCode && this.isMicroCode == codeSetting.isMicroCode && this.inverseCode == codeSetting.inverseCode && this.formatCode == codeSetting.formatCode) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.minLen * 31) + this.maxLen) * 31) + this.checkCharType) * 31) + (this.isStartEndType ? 1 : 0)) * 31) + this.startEndFormat) * 31) + (this.isExtendCode1 ? 1 : 0)) * 31) + (this.isExtendCode2 ? 1 : 0)) * 31) + (this.isSystemCharZero ? 1 : 0)) * 31) + (this.isExtendToCode ? 1 : 0)) * 31) + this.checkCharMode) * 31) + this.doubleCode) * 31) + (this.isMicroCode ? 1 : 0)) * 31) + this.inverseCode) * 31) + this.formatCode;
    }

    public String toString() {
        return "CodeSetting{minLen=" + this.minLen + ", maxLen=" + this.maxLen + ", checkCharType=" + this.checkCharType + ", isStartEndType=" + this.isStartEndType + ", startEndFormat=" + this.startEndFormat + ", isExtendCode1=" + this.isExtendCode1 + ", isExtendCode2=" + this.isExtendCode2 + ", isSystemCharZero=" + this.isSystemCharZero + ", isExtendToCode=" + this.isExtendToCode + ", checkCharMode=" + this.checkCharMode + ", doubleCode=" + this.doubleCode + ", isMicroCode=" + this.isMicroCode + ", inverseCode=" + this.inverseCode + ", formatCode=" + this.formatCode + '}';
    }
}
