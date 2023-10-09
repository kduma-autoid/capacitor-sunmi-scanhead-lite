package com.sunmi.scanner.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class CodeEnable implements Parcelable {
    public static final Creator<CodeEnable> CREATOR = new Creator<CodeEnable>() {
        public CodeEnable createFromParcel(Parcel parcel) {
            return new CodeEnable(parcel);
        }

        public CodeEnable[] newArray(int i) {
            return new CodeEnable[i];
        }
    };
    public String[] codes;
    public boolean[] enable;

    public int describeContents() {
        return 0;
    }

    public CodeEnable() {
    }

    protected CodeEnable(Parcel parcel) {
        this.codes = parcel.createStringArray();
        this.enable = parcel.createBooleanArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.codes);
        parcel.writeBooleanArray(this.enable);
    }
}
