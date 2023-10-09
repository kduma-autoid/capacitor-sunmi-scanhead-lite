package com.sunmi.scanner.entity;

import android.os.Parcel;
import android.os.Parcelable;

//import com.sunmi.apps.util.data.ImageUtils;
import com.sunmi.scanner.ScannerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import kotlin.jvm.internal.Intrinsics;

public class ServiceSetting implements Parcelable {
    public static final Parcelable.Creator<ServiceSetting> CREATOR = new Parcelable.Creator<ServiceSetting>() {
        public ServiceSetting createFromParcel(Parcel parcel) {
            return new ServiceSetting(parcel);
        }

        public ServiceSetting[] newArray(int i) {
            return new ServiceSetting[i];
        }
    };
    public LinkedHashMap<String, String> advancedConfig;
    public int mAdvancedFormat = 0;
    public String mBroadcastAction = ScannerService.ACTION_DATA_CODE_RECEIVED;
    public String mByteKey = ScannerService.SOURCE;
    public int mCenterFlagScan = 0;
    public int mContinuousTime = 500;
    public String mDataKey = ScannerService.DATA;
    @Deprecated
    public int mDecodeMode = -1;
    @Deprecated
    public int mDecodeWindowPercent = 50;
    public String mEndDecodeAction = "";
    public int[] mOutAutoAdd = {0, 1, 0};
    public int mOutBroadcast = 1;
    public int mOutCharInterval = 0;
    public int mOutCodeCharSet = 0;
    public int mOutCodeID = 0;
    public int mOutType = 2;
    public int mPrefix = 0;
    public String mPrefixContext = "";
    public String mStartDecodeAction = "";
    public int mSuffix = 0;
    public String mSuffixContext = "";
    public int[] mTips = {1, 1};
    public int[] mTrigger = {0};
    public int mTriggerMethod = 0;
    public int mTriggerTimeOut = 2000;
    public int scanExpSwitch = -1;
    public int specificScene = -1;
    public int mRemoveGroupChar = 0;
    public int mPrefixCount = 0;
    public int mSuffixCount = 0;

    public int describeContents() {
        return 0;
    }

    public ServiceSetting() {
    }

    protected ServiceSetting(Parcel parcel) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");

        this.mOutCodeCharSet = parcel.readInt();

        this.mTips = new int[]{1, 1};
        int[] createIntArray = parcel.createIntArray();
        this.mTips = createIntArray == null ? new int[]{1, 1} : createIntArray;

        this.mOutBroadcast = 1;
        this.mOutBroadcast = parcel.readInt();

        this.mOutType = 2;
        this.mOutType = parcel.readInt();

        this.mOutAutoAdd = new int[]{0, 1, 0, 0};
        int[] createIntArray2 = parcel.createIntArray();
        this.mOutAutoAdd = createIntArray2 == null ? new int[]{0, 1, 0, 0} : createIntArray2;

        this.mOutCharInterval = parcel.readInt();

        this.mPrefix = parcel.readInt();
        this.mSuffix = parcel.readInt();

        this.mPrefixContext = "";
        String readString = parcel.readString();
        this.mPrefixContext = readString == null ? "" : readString;

        this.mSuffixContext = "";
        String readString2 = parcel.readString();
        this.mSuffixContext = readString2 != null ? readString2 : "";

        this.mAdvancedFormat = parcel.readInt();

        this.mTriggerMethod = parcel.readInt();

        this.mTriggerTimeOut = 5000;
        this.mTriggerTimeOut = parcel.readInt();

        this.mTrigger = new int[]{0};
        int[] createIntArray3 = parcel.createIntArray();
        this.mTrigger = createIntArray3 == null ? new int[]{0} : createIntArray3;

        this.mOutCodeID = parcel.readInt();

        this.mDecodeMode = -1;
        this.mDecodeMode = parcel.readInt();

        this.mDecodeWindowPercent = 50;
        this.mDecodeWindowPercent = parcel.readInt();

        this.mCenterFlagScan = parcel.readInt();

        this.mContinuousTime = 500;
        this.mContinuousTime = parcel.readInt();

        this.mPrefixCount = parcel.readInt();
        this.mSuffixCount = parcel.readInt();
        this.mRemoveGroupChar = parcel.readInt();

        this.advancedConfig = new LinkedHashMap<>();
        this.mBroadcastAction = "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED";
        this.mDataKey = "data";
        this.mByteKey = "source_byte";
        this.mStartDecodeAction = "";
        this.mEndDecodeAction = "";
        this.scanExpSwitch = 0;
        this.specificScene = 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mOutCodeCharSet);
        parcel.writeIntArray(this.mTips);
        parcel.writeInt(this.mOutBroadcast);
        parcel.writeInt(this.mOutType);
        parcel.writeIntArray(this.mOutAutoAdd);
        parcel.writeInt(this.mOutCharInterval);
        parcel.writeInt(this.mPrefix);
        parcel.writeInt(this.mSuffix);
        parcel.writeString(this.mPrefixContext);
        parcel.writeString(this.mSuffixContext);
        parcel.writeInt(this.mAdvancedFormat);
        parcel.writeInt(this.mTriggerMethod);
        parcel.writeInt(this.mTriggerTimeOut);
        parcel.writeIntArray(this.mTrigger);
        parcel.writeInt(this.mOutCodeID);
        parcel.writeInt(this.mDecodeMode);
        parcel.writeInt(this.mDecodeWindowPercent);
        parcel.writeInt(this.mCenterFlagScan);
        parcel.writeInt(this.mContinuousTime);
        parcel.writeInt(this.mPrefixCount);
        parcel.writeInt(this.mSuffixCount);
        parcel.writeInt(this.mRemoveGroupChar);
    }

    public byte[] getPrefix() {
        return this.mPrefixContext.getBytes();
    }

    public byte[] getSuffix() {
        return this.mSuffixContext.getBytes();
    }

    public ArrayList<Pair> getAdvancedConfig() {
        if (this.advancedConfig == null) {
            return null;
        }
        ArrayList<Pair> arrayList = new ArrayList<>();
        for (Map.Entry next : this.advancedConfig.entrySet()) {
            arrayList.add(new Pair((String) next.getKey(), (String) next.getValue()));
        }
        return arrayList;
    }

    public void setAdvancedConfig(ArrayList<Pair> arrayList) {
        this.advancedConfig = new LinkedHashMap<>();

        for (Pair next : arrayList) {
            advancedConfig.put(next.first, next.second);
        }
    }

    public String toString() {
        return "ServiceSetting{mOutCodeCharSet=" + this.mOutCodeCharSet + ", mTips=" + Arrays.toString(this.mTips) + ", mOutBroadcast=" + this.mOutBroadcast + ", mOutType=" + this.mOutType + ", mOutAutoAdd=" + Arrays.toString(this.mOutAutoAdd) + ", mOutCharInterval=" + this.mOutCharInterval + ", mPrefix=" + this.mPrefix + ", mSuffix=" + this.mSuffix + ", mPrefixContext='" + this.mPrefixContext + '\'' + ", mSuffixContext='" + this.mSuffixContext + '\'' + ", mAdvancedFormat=" + this.mAdvancedFormat + ", mTriggerMethod=" + this.mTriggerMethod + ", mTriggerTimeOut=" + this.mTriggerTimeOut + ", mContinuousTime=" + this.mContinuousTime + ", advancedConfig=" + this.advancedConfig + ", mTrigger=" + Arrays.toString(this.mTrigger) + ", mOutCodeID=" + this.mOutCodeID + ", mDecodeMode=" + this.mDecodeMode + ", mDecodeWindowPercent=" + this.mDecodeWindowPercent + ", mCenterFlagScan=" + this.mCenterFlagScan + '}';
    }

}
