package com.sunmi.scanner_head.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public class CodesRules implements Parcelable {
    public static final Parcelable.Creator<CodesRules> CREATOR = new Parcelable.Creator<CodesRules>() {
        public CodesRules createFromParcel(Parcel parcel) {
            return new CodesRules(parcel);
        }

        public CodesRules[] newArray(int i) {
            return new CodesRules[i];
        }
    };
    public int[] checkCharMode = new int[0];
    public int[] checkCharType = new int[0];
    public int doubleCode = -1;
    public int extendCode1Type = -1;
    public int extendCode2Type = -1;
    public int extendToCode = -1;
    public int formatMode = -1;
    public int inverseCode = -1;
    public int maxLen = -1;
    public int microCode = -1;
    public int minLen = -1;
    public int startEndType = -1;
    public int systemCharZero = -1;

    public int describeContents() {
        return 0;
    }

    public CodesRules() {
    }

    protected CodesRules(Parcel parcel) {
        this.minLen = parcel.readInt();
        this.maxLen = parcel.readInt();
        this.checkCharType = parcel.createIntArray();
        this.startEndType = parcel.readInt();
        this.extendCode1Type = parcel.readInt();
        this.extendCode2Type = parcel.readInt();
        this.systemCharZero = parcel.readInt();
        this.extendToCode = parcel.readInt();
        this.checkCharMode = parcel.createIntArray();
        this.doubleCode = parcel.readInt();
        this.microCode = parcel.readInt();
        this.inverseCode = parcel.readInt();
        this.formatMode = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.minLen);
        parcel.writeInt(this.maxLen);
        parcel.writeIntArray(this.checkCharType);
        parcel.writeInt(this.startEndType);
        parcel.writeInt(this.extendCode1Type);
        parcel.writeInt(this.extendCode2Type);
        parcel.writeInt(this.systemCharZero);
        parcel.writeInt(this.extendToCode);
        parcel.writeIntArray(this.checkCharMode);
        parcel.writeInt(this.doubleCode);
        parcel.writeInt(this.microCode);
        parcel.writeInt(this.inverseCode);
        parcel.writeInt(this.formatMode);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CodesRules codesRules = (CodesRules) obj;
        if (this.minLen == codesRules.minLen && this.maxLen == codesRules.maxLen && this.startEndType == codesRules.startEndType && this.extendCode1Type == codesRules.extendCode1Type && this.extendCode2Type == codesRules.extendCode2Type && this.systemCharZero == codesRules.systemCharZero && this.extendToCode == codesRules.extendToCode && this.doubleCode == codesRules.doubleCode && this.microCode == codesRules.microCode && this.inverseCode == codesRules.inverseCode && this.formatMode == codesRules.formatMode && Arrays.equals(this.checkCharType, codesRules.checkCharType)) {
            return Arrays.equals(this.checkCharMode, codesRules.checkCharMode);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.minLen * 31) + this.maxLen) * 31) + Arrays.hashCode(this.checkCharType)) * 31) + this.startEndType) * 31) + this.extendCode1Type) * 31) + this.extendCode2Type) * 31) + this.systemCharZero) * 31) + this.extendToCode) * 31) + Arrays.hashCode(this.checkCharMode)) * 31) + this.doubleCode) * 31) + this.microCode) * 31) + this.inverseCode) * 31) + this.formatMode;
    }

    public String toString() {
        return "CodesRules{minLen=" + this.minLen + ", maxLen=" + this.maxLen + ", checkCharType=" + Arrays.toString(this.checkCharType) + ", startEndType=" + this.startEndType + ", extendCode1Type=" + this.extendCode1Type + ", extendCode2Type=" + this.extendCode2Type + ", systemCharZero=" + this.systemCharZero + ", extendToCode=" + this.extendToCode + ", checkCharMode=" + Arrays.toString(this.checkCharMode) + ", doubleCode=" + this.doubleCode + ", microCode=" + this.microCode + ", inverseCode=" + this.inverseCode + ", formatMode=" + this.formatMode + '}';
    }
}
