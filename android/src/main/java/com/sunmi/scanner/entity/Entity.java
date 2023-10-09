package com.sunmi.scanner.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class Entity<T> implements Parcelable {
    private T bean = null;
    private String clazz;

    public static final Creator<Entity> CREATOR = new Creator<Entity>() {
        @Override
        public Entity createFromParcel(Parcel in) {
            return new Entity(in);
        }

        @Override
        public Entity[] newArray(int size) {
            return new Entity[size];
        }
    };

    public Entity(T in) {
        this.clazz = in.getClass().getName();
        this.bean = in;
    }

    protected Entity(Parcel parcel) {
        ClassLoader classLoader = getClass().getClassLoader();
        this.clazz = parcel.readString();

        assert this.clazz != null;
        if (this.clazz.contains("ArrayList")) {
            ArrayList arrayList = new ArrayList();
            this.bean = (T) arrayList;
            parcel.readList((List) arrayList, classLoader);
            return;
        }

        this.bean = parcel.readParcelable(classLoader);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(this.clazz);
        T t = this.bean;
        if (t instanceof Parcelable) {
            dest.writeParcelable((Parcelable) t, flags);
        } else if (t instanceof List) {
            dest.writeList((List) t);
        }
    }

    public T getBean() {
        return this.bean;
    }

    public String getClazz() {
        return clazz;
    }
}
