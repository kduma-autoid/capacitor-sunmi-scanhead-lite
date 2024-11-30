package com.sunmi.scanner_head.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Pair implements Parcelable {
    public static final Parcelable.Creator<Pair> CREATOR = new Parcelable.Creator<Pair>() {
        public Pair createFromParcel(Parcel parcel) {
            return new Pair(parcel);
        }

        public Pair[] newArray(int i) {
            return new Pair[i];
        }
    };
    public String first;
    public String second;

    public int describeContents() {
        return 0;
    }

    public Pair() {
    }

    public Pair(String str, String str2) {
        this.first = str;
        this.second = str2;
    }

    protected Pair(Parcel parcel) {
        this.first = parcel.readString();
        this.second = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.first);
        parcel.writeString(this.second);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.first.equals(((Pair) obj).first);
    }

    public int hashCode() {
        return this.first.hashCode();
    }

    public String toString() {
        return "Pair{first='" + this.first + '\'' + ", second='" + this.second + '\'' + '}';
    }
}