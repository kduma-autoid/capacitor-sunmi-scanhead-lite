package dev.duma.android.sunmi.scanconfigurationhelper.models;

import com.sunmi.scanner.ScannerService;
import com.sunmi.scanner.entity.Pair;
import com.sunmi.scanner.entity.ServiceSetting;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ServiceConfiguration implements Cloneable {
//    @Deprecated
//    public int mDecodeMode = -1;
//    @Deprecated
//    public int mDecodeWindowPercent = 50;

    /**
     * mOutCodeCharSet
     */
    private OutputEncodingCodeEnum outputEncodingCode = OutputEncodingCodeEnum.UTF8;

    /**
     * mTrigger[0]
     */
    private boolean virtualFloatingScanButton = false;

    /**
     * mTips[0]
     */
    private boolean beep = true;

    /**
     * mTips[1]
     */
    private boolean vibrate = true;

    /**
     * mTriggerMethod
     */
    private TriggerMethodEnum triggerMethod = TriggerMethodEnum.Trigger;

    /**
     * mTriggerTimeOut
     */
    private int scanTriggerTimeOut = 2000;

    /**
     *
     */
    private int triggerOverTime = 5000;

    /**
     * mContinuousTime
     */
    private int triggerContinuousTime = 500;

    /**
     * mOutCodeID
     */
    private ScanResultCodeIDEnum scanResultCodeID = ScanResultCodeIDEnum.None;

    /**
     * mPrefix & mPrefixContext
     */
    private String prefix = null;

    /**
     * mSuffix & mSuffixContext
     */
    private String suffix = null;

    /**
     * mOutBroadcast
     */
    private boolean outputBroadcastEnabled = true;

    /**
     * mBroadcastAction
     */
    private String outputBroadcastAction = ScannerService.ACTION_DATA_CODE_RECEIVED;

    /**
     * mDataKey
     */
    private String outputBroadcastDataKey = ScannerService.DATA;

    /**
     * mByteKey
     */
    private String outputBroadcastByteKey = ScannerService.SOURCE;

    /**
     * mStartDecodeAction
     */
    private String outputBroadcastStartAction = null;

    /**
     * mEndDecodeAction
     */
    private String outputBroadcastEndAction = null;

    /**
     * mOutType
     */
    private OutputTypeEnum outputType = OutputTypeEnum.Keystroke;

    /**
     * mOutAutoAdd[0]
     */
    private boolean addTab = false;

    /**
     * mOutAutoAdd[1]
     */
    private boolean addReturn = true;

    /**
     * mOutAutoAdd[2]
     */
    private boolean asEvents = false;

    /**
     * mOutAutoAdd[3]
     */
    private boolean addSpace = false;

    /**
     * mOutCharInterval
     */
    private int outputCharacterInterval = 0;

    /**
     * mAdvancedFormat
     */
    private boolean advancedFormatEnabled = false;

    /**
     * advancedConfig
     */
    private ArrayList<Pair> advancedFormat = new ArrayList<>();

    /**
     * mCenterFlagScan
     */
    private CenterDecodingSettingEnum centerFlagScan = CenterDecodingSettingEnum.Disabled;


    public static ServiceConfiguration fromServiceSetting(ServiceSetting serviceSetting, ArrayList<Pair> response_format) {
        ServiceConfiguration c = new ServiceConfiguration();

        c.advancedFormat = response_format;

        c.centerFlagScan = switch (serviceSetting.mCenterFlagScan) {
            default -> CenterDecodingSettingEnum.Disabled;
            case 1 -> CenterDecodingSettingEnum.CenterOnly;
            case 2 -> CenterDecodingSettingEnum.CenterFirst;
        };
        c.virtualFloatingScanButton = serviceSetting.mTrigger[0] == 1;
        c.advancedFormatEnabled = serviceSetting.mAdvancedFormat == 1;
        c.outputBroadcastEnabled = serviceSetting.mOutBroadcast == 1;
        c.beep = serviceSetting.mTips[0] == 1;
        c.vibrate = serviceSetting.mTips[1] == 1;

        c.triggerMethod = switch (serviceSetting.mTriggerMethod) {
            default -> TriggerMethodEnum.Trigger;
            case 1 -> TriggerMethodEnum.Continuous;
            case 2 -> TriggerMethodEnum.Pulse;
            case 3 -> TriggerMethodEnum.LongPress;
        };

        c.scanResultCodeID = switch (serviceSetting.mOutCodeID) {
            case -1 -> ScanResultCodeIDEnum.Unsupported;
            default -> ScanResultCodeIDEnum.None;
            case 1 -> ScanResultCodeIDEnum.SunmiId;
            case 2 -> ScanResultCodeIDEnum.AimId;
            case 3 -> ScanResultCodeIDEnum.SymbolId;
        };

        c.outputType = switch (serviceSetting.mOutType) {
            case 0 -> OutputTypeEnum.DirectFill;
            case 1 -> OutputTypeEnum.DirectFillWithReplace;
            default -> OutputTypeEnum.Keystroke;
            case 3 -> OutputTypeEnum.Disabled;
        };

        c.outputEncodingCode = switch (serviceSetting.mOutCodeCharSet) {
            default -> OutputEncodingCodeEnum.UTF8;
            case 1 -> OutputEncodingCodeEnum.GBK;
            case 2 -> OutputEncodingCodeEnum.ISO88591;
            case 3 -> OutputEncodingCodeEnum.SHIFTJIS;
            case 4 -> OutputEncodingCodeEnum.Auto;
            case 5 -> OutputEncodingCodeEnum.WINDOWS1256;
            case 6 -> OutputEncodingCodeEnum.WINDOWS874;
            case 7 -> OutputEncodingCodeEnum.Unicode;
            case 8 -> OutputEncodingCodeEnum.Big5;
            case 9 -> OutputEncodingCodeEnum.ASCII;
            case 10 -> OutputEncodingCodeEnum.GB2312;
            case 11 -> OutputEncodingCodeEnum.GB18030;
        };

        c.scanTriggerTimeOut = serviceSetting.mTriggerTimeOut;
        c.triggerContinuousTime = serviceSetting.mContinuousTime;
        c.outputCharacterInterval = serviceSetting.mOutCharInterval;

        if(serviceSetting.mPrefix == 1) {
            c.prefix = serviceSetting.mPrefixContext;
        } else {
            c.prefix = null;
        }

        if(serviceSetting.mSuffix == 1) {
            c.suffix = serviceSetting.mSuffixContext;
        } else {
            c.suffix = null;
        }

        c.addTab = serviceSetting.mOutAutoAdd[0] == 1;
        c.addReturn = serviceSetting.mOutAutoAdd[1] == 1;
        if(serviceSetting.mOutAutoAdd.length > 2) {
            c.asEvents = serviceSetting.mOutAutoAdd[2] == 1;
        }
        if(serviceSetting.mOutAutoAdd.length > 3) {
            c.addSpace = serviceSetting.mOutAutoAdd[3] == 1;
        }

        c.outputBroadcastAction = serviceSetting.mBroadcastAction;
        c.outputBroadcastDataKey = serviceSetting.mDataKey;
        c.outputBroadcastByteKey = serviceSetting.mByteKey;
        c.outputBroadcastStartAction = serviceSetting.mStartDecodeAction;
        c.outputBroadcastEndAction = serviceSetting.mEndDecodeAction;

        // c.triggerOverTime = null;

        return c;
    }

    public ServiceSetting toServiceSetting(ServiceSetting defaults) {
        ServiceSetting s = cloneServiceSetting(defaults);

        s.setAdvancedConfig(advancedFormat);

        if(s.mCenterFlagScan != -1) {
            s.mCenterFlagScan = switch (centerFlagScan) {
                case Disabled -> 0;
                case CenterOnly -> 1;
                case CenterFirst -> 2;
            };
        }
        s.mTrigger[0] = virtualFloatingScanButton ? 1 : 0;
        s.mAdvancedFormat = advancedFormatEnabled ? 1 : 0;
        s.mOutBroadcast = outputBroadcastEnabled ? 1 : 0;

        if(s.mTips[0] != -1) {
            s.mTips[0] = beep ? 1 : 0;
        }

        s.mTips[1] = vibrate ? 1 : 0;

        s.mTriggerMethod = switch (triggerMethod) {
            case Trigger -> 0;
            case Continuous -> 1;
            case Pulse -> 2;
            case LongPress -> 3;
        };

        s.mTriggerTimeOut = scanTriggerTimeOut;
        s.mContinuousTime = triggerContinuousTime;
        s.mOutCharInterval = outputCharacterInterval;

        if(s.mOutCodeID != -1) {
           s.mOutCodeID = switch (scanResultCodeID) {
               case Unsupported -> -1;
               case None -> 0;
               case SunmiId -> 1;
               case AimId -> 2;
               case SymbolId -> 3;
           };
        }

        s.mOutType = switch (outputType) {
            case DirectFill -> 0;
            case DirectFillWithReplace -> 1;
            case Keystroke -> 2;
            case Disabled -> 3;
        };

        s.mOutCodeCharSet = switch (outputEncodingCode) {
            case UTF8 -> 0;
            case GBK -> 1;
            case ISO88591 -> 2;
            case SHIFTJIS -> 3;
            case Auto -> 4;
            case WINDOWS1256 -> 5;
            case WINDOWS874 -> 6;
            case Unicode -> 7;
            case Big5 -> 8;
            case ASCII -> 9;
            case GB2312 -> 10;
            case GB18030 -> 11;
        };

        if(prefix == null) {
            s.mPrefix = 0;
            s.mPrefixContext = "";
        } else {
            s.mPrefix = 1;
            s.mPrefixContext = prefix;
        }

        if(suffix == null) {
            s.mSuffix = 0;
            s.mSuffixContext = "";
        } else {
            s.mSuffix = 1;
            s.mSuffixContext = suffix;
        }

        s.mOutAutoAdd[0] = addTab ? 1 : 0;
        s.mOutAutoAdd[1] = addReturn ? 1 : 0;
        if(s.mOutAutoAdd.length > 2) {
            s.mOutAutoAdd[2] = asEvents ? 1 : 0;
        }
        if(s.mOutAutoAdd.length > 3) {
            s.mOutAutoAdd[3] = addSpace ? 1 : 0;
        }

        s.mBroadcastAction = outputBroadcastAction;
        s.mDataKey = outputBroadcastDataKey;
        s.mByteKey = outputBroadcastByteKey;
        s.mStartDecodeAction = outputBroadcastStartAction;
        s.mEndDecodeAction = outputBroadcastEndAction;

        // c.triggerOverTime = null;

        return s;
    }

//    public void Commit(ServiceSetting defaults) {
//        ArrayList<String> commands = new ArrayList<>();
//        ServiceSetting s = toServiceSetting(cloneServiceSetting(defaults));
//
//        commands.add(SunmiHelper.setTips(method));
//
//        int method = switch (triggerMethod) {
//            case Trigger -> 0;
//            case Continuous -> 1;
//            case Pulse -> 2;
//            case LongPress -> 3;
//        };
//
//        commands.add(SunmiHelper.setTriggerMethod(method));
//        commands.add(SunmiHelper.setScanTriggerModel(method));
//
//        if (triggerMethod == TriggerMethodEnum.Pulse) {
//            commands.add(SunmiHelper.setTriggerOverTime(triggerOverTime));
//            commands.add(SunmiHelper.setScanTriggerTimeOut(scanTriggerTimeOut));
//        } else {
//            if (triggerMethod == TriggerMethodEnum.Continuous || triggerMethod == TriggerMethodEnum.LongPress) {
//                commands.add(SunmiHelper.setTriggerContinuousTime(triggerContinuousTime));
//            }
//            commands.add(SunmiHelper.setTriggerOverTime(5000));
//            commands.add(SunmiHelper.setScanTriggerTimeOut(5000));
//        }
//    }

    private ServiceSetting cloneServiceSetting(ServiceSetting original) {
        ServiceSetting clone = new ServiceSetting();

        clone.mOutCodeCharSet = original.mOutCodeCharSet;
        clone.mTips = original.mTips;
        clone.mOutBroadcast = original.mOutBroadcast;
        clone.mOutType = original.mOutType;
        clone.mOutAutoAdd = original.mOutAutoAdd;
        clone.mOutCharInterval = original.mOutCharInterval;
        clone.mPrefix = original.mPrefix;
        clone.mSuffix = original.mSuffix;
        clone.mPrefixContext = original.mPrefixContext;
        clone.mSuffixContext = original.mSuffixContext;
        clone.mAdvancedFormat = original.mAdvancedFormat;
        clone.mTriggerMethod = original.mTriggerMethod;
        clone.mTriggerTimeOut = original.mTriggerTimeOut;
        clone.mTrigger = original.mTrigger;
        clone.mOutCodeID = original.mOutCodeID;
        clone.mDecodeMode = original.mDecodeMode;
        clone.mDecodeWindowPercent = original.mDecodeWindowPercent;
        clone.mCenterFlagScan = original.mCenterFlagScan;
        clone.mContinuousTime = original.mContinuousTime;

        clone.mDataKey = original.mDataKey;
        clone.mByteKey = original.mByteKey;
        clone.mStartDecodeAction = original.mStartDecodeAction;
        clone.mEndDecodeAction = original.mEndDecodeAction;
        clone.mBroadcastAction = original.mBroadcastAction;
        //noinspection unchecked
        // clone.advancedConfig = (LinkedHashMap<String, String>) original.advancedConfig.clone();

        return clone;
    }

    public OutputEncodingCodeEnum getOutputEncodingCode() {
        return outputEncodingCode;
    }

    public void setOutputEncodingCode(OutputEncodingCodeEnum outputEncodingCode) {
        this.outputEncodingCode = outputEncodingCode;
    }

    public boolean isVirtualFloatingScanButton() {
        return virtualFloatingScanButton;
    }

    public void setVirtualFloatingScanButton(boolean virtualFloatingScanButton) {
        this.virtualFloatingScanButton = virtualFloatingScanButton;
    }

    public boolean isBeep() {
        return beep;
    }

    public void setBeep(boolean beep) {
        this.beep = beep;
    }

    public boolean isVibrate() {
        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        this.vibrate = vibrate;
    }

    public TriggerMethodEnum getTriggerMethod() {
        return triggerMethod;
    }

    public void setTriggerMethod(TriggerMethodEnum triggerMethod) {
        this.triggerMethod = triggerMethod;
    }

    public int getScanTriggerTimeOut() {
        return scanTriggerTimeOut;
    }

    public void setScanTriggerTimeOut(int scanTriggerTimeOut) {
        this.scanTriggerTimeOut = scanTriggerTimeOut;
    }

    public int getTriggerOverTime() {
        return triggerOverTime;
    }

    public void setTriggerOverTime(int triggerOverTime) {
        this.triggerOverTime = triggerOverTime;
    }

    public int getTriggerContinuousTime() {
        return triggerContinuousTime;
    }

    public void setTriggerContinuousTime(int triggerContinuousTime) {
        this.triggerContinuousTime = triggerContinuousTime;
    }

    public ScanResultCodeIDEnum getScanResultCodeID() {
        return scanResultCodeID;
    }

    public void setScanResultCodeID(ScanResultCodeIDEnum scanResultCodeID) {
        this.scanResultCodeID = scanResultCodeID;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isOutputBroadcastEnabled() {
        return outputBroadcastEnabled;
    }

    public void setOutputBroadcastEnabled(boolean outputBroadcastEnabled) {
        this.outputBroadcastEnabled = outputBroadcastEnabled;
    }

    public String getOutputBroadcastAction() {
        return outputBroadcastAction;
    }

    public void setOutputBroadcastAction(String outputBroadcastAction) {
        this.outputBroadcastAction = outputBroadcastAction;
    }

    public String getOutputBroadcastDataKey() {
        return outputBroadcastDataKey;
    }

    public void setOutputBroadcastDataKey(String outputBroadcastDataKey) {
        this.outputBroadcastDataKey = outputBroadcastDataKey;
    }

    public String getOutputBroadcastByteKey() {
        return outputBroadcastByteKey;
    }

    public void setOutputBroadcastByteKey(String outputBroadcastByteKey) {
        this.outputBroadcastByteKey = outputBroadcastByteKey;
    }

    public String getOutputBroadcastStartAction() {
        return outputBroadcastStartAction;
    }

    public void setOutputBroadcastStartAction(String outputBroadcastStartAction) {
        this.outputBroadcastStartAction = outputBroadcastStartAction;
    }

    public String getOutputBroadcastEndAction() {
        return outputBroadcastEndAction;
    }

    public void setOutputBroadcastEndAction(String outputBroadcastEndAction) {
        this.outputBroadcastEndAction = outputBroadcastEndAction;
    }

    public OutputTypeEnum getOutputType() {
        return outputType;
    }

    public void setOutputType(OutputTypeEnum outputType) {
        this.outputType = outputType;
    }

    public boolean isAddTab() {
        return addTab;
    }

    public void setAddTab(boolean addTab) {
        this.addTab = addTab;
    }

    public boolean isAddReturn() {
        return addReturn;
    }

    public void setAddReturn(boolean addReturn) {
        this.addReturn = addReturn;
    }

    public boolean isAsEvents() {
        return asEvents;
    }

    public void setAsEvents(boolean asEvents) {
        this.asEvents = asEvents;
    }

    public boolean isAddSpace() {
        return addSpace;
    }

    public void setAddSpace(boolean addSpace) {
        this.addSpace = addSpace;
    }

    public int getOutputCharacterInterval() {
        return outputCharacterInterval;
    }

    public void setOutputCharacterInterval(int outputCharacterInterval) {
        this.outputCharacterInterval = outputCharacterInterval;
    }

    public boolean isAdvancedFormatEnabled() {
        return advancedFormatEnabled;
    }

    public void setAdvancedFormatEnabled(boolean advancedFormatEnabled) {
        this.advancedFormatEnabled = advancedFormatEnabled;
    }

    public CenterDecodingSettingEnum getCenterFlagScan() {
        return centerFlagScan;
    }

    public void setCenterFlagScan(CenterDecodingSettingEnum centerFlagScan) {
        this.centerFlagScan = centerFlagScan;
    }
}
