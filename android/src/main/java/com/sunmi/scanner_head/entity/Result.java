package com.sunmi.scanner_head.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {
    public static final Creator<Result> CREATOR = new Creator<Result>() {
        public Result createFromParcel(Parcel parcel) {
            return new Result(parcel);
        }

        public Result[] newArray(int i) {
            return new Result[i];
        }
    };
    public String result;

    public int describeContents() {
        return 0;
    }

    public Result(String str) {
        this.result = str;
    }

    protected Result(Parcel parcel) {
        this.result = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.result);
    }

    public String toString() {
        return "Result{result='" + this.result + '\'' + '}';
    }
}
