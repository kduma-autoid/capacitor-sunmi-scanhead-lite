package dev.duma.android.sunmi.scanconfigurationhelper.config;

import com.sunmi.scanner.ScannerService;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.regex.Pattern;

import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CenterDecodingSettingEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ConfigurationFieldEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputEncodingCodeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputTypeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ScanResultCodeIDEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.SpecificSceneEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.TriggerMethodEnum;

public class ServiceConfiguration {
//    @Deprecated
//    public int mDecodeMode = -1;
//    @Deprecated
//    public int mDecodeWindowPercent = 50;

    protected final EnumSet<ConfigurationFieldEnum> updatedFields = EnumSet.noneOf(ConfigurationFieldEnum.class);
    protected final EnumSet<ConfigurationFieldEnum> unsupportedFields = EnumSet.noneOf(ConfigurationFieldEnum.class);

    public boolean isUpdated(ConfigurationFieldEnum field) {
        return this.updatedFields.contains(field);
    }

    public boolean isSupported(ConfigurationFieldEnum field) {
        return !this.unsupportedFields.contains(field);
    }

    /**
     * mOutCodeCharSet
     */
    protected OutputEncodingCodeEnum outputEncodingCode = OutputEncodingCodeEnum.UTF8;

    /**
     * mTrigger[0]
     */
    protected boolean virtualFloatingScanButton = false;

    /**
     * mTips[0]
     */
    protected boolean beep = true;

    /**
     * mTips[1]
     */
    protected boolean vibrate = true;

    /**
     * mTriggerMethod
     */
    protected TriggerMethodEnum triggerMethod = TriggerMethodEnum.Trigger;

    /**
     * mTriggerTimeOut
     */
    protected int scanTriggerTimeOut = 2000;

    /**
     *
     */
    protected int triggerOverTime = 5000;

    /**
     * mContinuousTime
     */
    protected int triggerContinuousTime = 500;

    /**
     * mOutCodeID
     */
    protected ScanResultCodeIDEnum scanResultCodeID = ScanResultCodeIDEnum.None;

    /**
     * mPrefix & mPrefixContext
     */
    protected String prefix = null;

    /**
     * mSuffix & mSuffixContext
     */
    protected String suffix = null;

    /**
     * mOutBroadcast
     */
    protected boolean outputBroadcastEnabled = true;

    /**
     * mBroadcastAction
     */
    protected String outputBroadcastAction = ScannerService.ACTION_DATA_CODE_RECEIVED;

    /**
     * mDataKey
     */
    protected String outputBroadcastDataKey = ScannerService.DATA;

    /**
     * mByteKey
     */
    protected String outputBroadcastByteKey = ScannerService.SOURCE;

    /**
     * mStartDecodeAction
     */
    protected String outputBroadcastStartAction = null;

    /**
     * mEndDecodeAction
     */
    protected String outputBroadcastEndAction = null;

    /**
     * mOutType
     */
    protected OutputTypeEnum outputType = OutputTypeEnum.Keystroke;

    /**
     * mOutAutoAdd[0]
     */
    protected boolean addTab = false;

    /**
     * mOutAutoAdd[1]
     */
    protected boolean addReturn = true;

    /**
     * mOutAutoAdd[2]
     */
    protected boolean asEvents = false;

    /**
     * mOutAutoAdd[3]
     */
    protected boolean addSpace = false;

    /**
     * mOutCharInterval
     */
    protected int outputCharacterInterval = 0;

    /**
     * mAdvancedFormat
     */
    protected boolean advancedFormatEnabled = false;

    /**
     * advancedConfig
     */
    protected HashMap<String, String> advancedFormats = new HashMap<>();

    /**
     * mCenterFlagScan
     */
    protected CenterDecodingSettingEnum centerFlagScan = CenterDecodingSettingEnum.Disabled;


    /**
     * scanExpSwitch
     */
    protected boolean flash = true;

    /**
     * specificScene
     */
    protected SpecificSceneEnum scene = SpecificSceneEnum.Default;

    /**
     * mRemoveGroupChar
     */
    protected boolean removeGroupSeparator = false;

    /**
     * mPrefixCount
     */
    protected int prefixCharactersRemoved = 0;

    /**
     * mSuffixCount
     */
    protected int suffixCharactersRemoved = 0;

    public OutputEncodingCodeEnum getOutputEncodingCode() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputEncodingCode)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputEncodingCode+" is not supported on this system!");
        }

        return outputEncodingCode;
    }

    public void setOutputEncodingCode(OutputEncodingCodeEnum outputEncodingCode) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputEncodingCode)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputEncodingCode+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputEncodingCode)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputEncodingCode);
        }

        this.outputEncodingCode = outputEncodingCode;
    }

    public boolean isVirtualFloatingScanButton() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.VirtualFloatingScanButton)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.VirtualFloatingScanButton+" is not supported on this system!");
        }

        return virtualFloatingScanButton;
    }

    public void setVirtualFloatingScanButton(boolean virtualFloatingScanButton) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.VirtualFloatingScanButton)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.VirtualFloatingScanButton+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.VirtualFloatingScanButton)) {
            this.updatedFields.add(ConfigurationFieldEnum.VirtualFloatingScanButton);
        }

        this.virtualFloatingScanButton = virtualFloatingScanButton;
    }

    public boolean isBeep() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Beep)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Beep+" is not supported on this system!");
        }

        return beep;
    }

    public void setBeep(boolean beep) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Beep)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Beep+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Beep)) {
            this.updatedFields.add(ConfigurationFieldEnum.Beep);
        }

        this.beep = beep;
    }

    public boolean isVibrate() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Vibrate)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Vibrate+" is not supported on this system!");
        }

        return vibrate;
    }

    public void setVibrate(boolean vibrate) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Vibrate)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Vibrate+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Vibrate)) {
            this.updatedFields.add(ConfigurationFieldEnum.Vibrate);
        }

        this.vibrate = vibrate;
    }

    public TriggerMethodEnum getTriggerMethod() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerMethod)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerMethod+" is not supported on this system!");
        }

        return triggerMethod;
    }

    public void setTriggerMethod(TriggerMethodEnum triggerMethod) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerMethod)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerMethod+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.TriggerMethod)) {
            this.updatedFields.add(ConfigurationFieldEnum.TriggerMethod);
        }

        this.triggerMethod = triggerMethod;
    }

    public int getScanTriggerTimeOut() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.ScanTriggerTimeOut)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.ScanTriggerTimeOut+" is not supported on this system!");
        }

        return scanTriggerTimeOut;
    }

    public void setScanTriggerTimeOut(int scanTriggerTimeOut) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.ScanTriggerTimeOut)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.ScanTriggerTimeOut+" is not supported on this system!");
        }

        if(scanTriggerTimeOut < 1000 || scanTriggerTimeOut > 9000) {
            throw new RuntimeException("ScanTriggerTimeOut is not in range of [1000, 9000]");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.ScanTriggerTimeOut)) {
            this.updatedFields.add(ConfigurationFieldEnum.ScanTriggerTimeOut);
        }

        this.scanTriggerTimeOut = scanTriggerTimeOut;
    }

    // TODO: Check usage
    public int getTriggerOverTime() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerOverTime)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerOverTime+" is not supported on this system!");
        }

        return triggerOverTime;
    }

    public void setTriggerOverTime(int triggerOverTime) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerOverTime)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerOverTime+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.TriggerOverTime)) {
            this.updatedFields.add(ConfigurationFieldEnum.TriggerOverTime);
        }

        this.triggerOverTime = triggerOverTime;
    }

    public int getTriggerContinuousTime() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerContinuousTime)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerContinuousTime+" is not supported on this system!");
        }

        return triggerContinuousTime;
    }

    public void setTriggerContinuousTime(int triggerContinuousTime) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.TriggerContinuousTime)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.TriggerContinuousTime+" is not supported on this system!");
        }

        if(triggerContinuousTime < 0 || triggerContinuousTime > 9000) {
            throw new RuntimeException("TriggerContinuousTime is not in range of [0, 9000]");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.TriggerContinuousTime)) {
            this.updatedFields.add(ConfigurationFieldEnum.TriggerContinuousTime);
        }

        this.triggerContinuousTime = triggerContinuousTime;
    }

    public ScanResultCodeIDEnum getScanResultCodeID() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.ScanResultCodeID)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.ScanResultCodeID+" is not supported on this system!");
        }

        return scanResultCodeID;
    }

    public void setScanResultCodeID(ScanResultCodeIDEnum scanResultCodeID) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.ScanResultCodeID)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.ScanResultCodeID+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.ScanResultCodeID)) {
            this.updatedFields.add(ConfigurationFieldEnum.ScanResultCodeID);
        }

        this.scanResultCodeID = scanResultCodeID;
    }

    public String getPrefix() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Prefix)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Prefix+" is not supported on this system!");
        }

        return prefix;
    }

    public void setPrefix(String prefix) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Prefix)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Prefix+" is not supported on this system!");
        }

        if(prefix == null || prefix.isEmpty()){
            prefix = null;
        } else if(!Pattern.compile("^[\\x00-\\xFF]+$").matcher(prefix).matches()) {
            throw new RuntimeException("Prefix value isn't ASCII");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Prefix)) {
            this.updatedFields.add(ConfigurationFieldEnum.Prefix);
        }

        this.prefix = prefix;
    }

    public String getSuffix() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Suffix)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Suffix+" is not supported on this system!");
        }

        return suffix;
    }

    public void setSuffix(String suffix) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Suffix)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Suffix+" is not supported on this system!");
        }

        if(suffix == null || suffix.isEmpty()){
            suffix = null;
        } else if(!Pattern.compile("^[\\x00-\\xFF]+$").matcher(suffix).matches()) {
            throw new RuntimeException("Suffix value isn't ASCII");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Suffix)) {
            this.updatedFields.add(ConfigurationFieldEnum.Suffix);
        }

        this.suffix = suffix;
    }

    public boolean isOutputBroadcastEnabled() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastEnabled)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastEnabled+" is not supported on this system!");
        }

        return outputBroadcastEnabled;
    }

    public void setOutputBroadcastEnabled(boolean outputBroadcastEnabled) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastEnabled)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastEnabled+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastEnabled)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastEnabled);
        }

        this.outputBroadcastEnabled = outputBroadcastEnabled;
    }

    public String getOutputBroadcastAction() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastAction+" is not supported on this system!");
        }

        return outputBroadcastAction;
    }

    public void setOutputBroadcastAction(String outputBroadcastAction) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastAction+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastAction)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastAction);
        }

        this.outputBroadcastAction = outputBroadcastAction;
    }

    public String getOutputBroadcastDataKey() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastDataKey)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastDataKey+" is not supported on this system!");
        }

        return outputBroadcastDataKey;
    }

    public void setOutputBroadcastDataKey(String outputBroadcastDataKey) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastDataKey)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastDataKey+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastDataKey)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastDataKey);
        }

        this.outputBroadcastDataKey = outputBroadcastDataKey;
    }

    public String getOutputBroadcastByteKey() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastByteKey)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastByteKey+" is not supported on this system!");
        }

        return outputBroadcastByteKey;
    }

    public void setOutputBroadcastByteKey(String outputBroadcastByteKey) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastByteKey)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastByteKey+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastByteKey)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastByteKey);
        }

        this.outputBroadcastByteKey = outputBroadcastByteKey;
    }

    public String getOutputBroadcastStartAction() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastStartAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastStartAction+" is not supported on this system!");
        }

        return outputBroadcastStartAction;
    }

    public void setOutputBroadcastStartAction(String outputBroadcastStartAction) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastStartAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastStartAction+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastStartAction)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastStartAction);
        }

        this.outputBroadcastStartAction = outputBroadcastStartAction;
    }

    public String getOutputBroadcastEndAction() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastEndAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastEndAction+" is not supported on this system!");
        }

        return outputBroadcastEndAction;
    }

    public void setOutputBroadcastEndAction(String outputBroadcastEndAction) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputBroadcastEndAction)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputBroadcastEndAction+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputBroadcastEndAction)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputBroadcastEndAction);
        }

        this.outputBroadcastEndAction = outputBroadcastEndAction;
    }

    public OutputTypeEnum getOutputType() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputType)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputType+" is not supported on this system!");
        }

        return outputType;
    }

    public void setOutputType(OutputTypeEnum outputType) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputType)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputType+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputType)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputType);
        }

        this.outputType = outputType;
    }

    public boolean isAddTab() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddTab)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddTab+" is not supported on this system!");
        }

        return addTab;
    }

    public void setAddTab(boolean addTab) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddTab)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddTab+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AddTab)) {
            this.updatedFields.add(ConfigurationFieldEnum.AddTab);
        }

        this.addTab = addTab;
    }

    public boolean isAddReturn() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddReturn)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddReturn+" is not supported on this system!");
        }

        return addReturn;
    }

    public void setAddReturn(boolean addReturn) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddReturn)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddReturn+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AddReturn)) {
            this.updatedFields.add(ConfigurationFieldEnum.AddReturn);
        }

        this.addReturn = addReturn;
    }

    public boolean isAsEvents() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AsEvents)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AsEvents+" is not supported on this system!");
        }

        return asEvents;
    }

    public void setAsEvents(boolean asEvents) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AsEvents)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AsEvents+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AsEvents)) {
            this.updatedFields.add(ConfigurationFieldEnum.AsEvents);
        }

        this.asEvents = asEvents;
    }

    public boolean isAddSpace() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddSpace)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddSpace+" is not supported on this system!");
        }

        return addSpace;
    }

    public void setAddSpace(boolean addSpace) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AddSpace)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AddSpace+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AddSpace)) {
            this.updatedFields.add(ConfigurationFieldEnum.AddSpace);
        }

        this.addSpace = addSpace;
    }

    public int getOutputCharacterInterval() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputCharacterInterval)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputCharacterInterval+" is not supported on this system!");
        }

        return outputCharacterInterval;
    }

    public void setOutputCharacterInterval(int outputCharacterInterval) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.OutputCharacterInterval)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.OutputCharacterInterval+" is not supported on this system!");
        }

        if(outputCharacterInterval < 0 || outputCharacterInterval > 100) {
            throw new RuntimeException("OutputCharacterInterval is not in range of [0, 100]");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.OutputCharacterInterval)) {
            this.updatedFields.add(ConfigurationFieldEnum.OutputCharacterInterval);
        }

        this.outputCharacterInterval = outputCharacterInterval;
    }

    public boolean isAdvancedFormatEnabled() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AdvancedFormatEnabled)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AdvancedFormatEnabled+" is not supported on this system!");
        }

        return advancedFormatEnabled;
    }

    public void setAdvancedFormatEnabled(boolean advancedFormatEnabled) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AdvancedFormatEnabled)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AdvancedFormatEnabled+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AdvancedFormatEnabled)) {
            this.updatedFields.add(ConfigurationFieldEnum.AdvancedFormatEnabled);
        }

        this.advancedFormatEnabled = advancedFormatEnabled;
    }

    public HashMap<String, String> getAdvancedFormats() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AdvancedFormat)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AdvancedFormat+" is not supported on this system!");
        }

        return advancedFormats;
    }

    public void setAdvancedFormats(HashMap<String, String> advancedFormats) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.AdvancedFormat)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.AdvancedFormat+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.AdvancedFormat)) {
            this.updatedFields.add(ConfigurationFieldEnum.AdvancedFormat);
        }

        this.advancedFormats = advancedFormats;
    }

    public CenterDecodingSettingEnum getCenterFlagScan() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.CenterFlagScan)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.CenterFlagScan+" is not supported on this system!");
        }

        return centerFlagScan;
    }

    public void setCenterFlagScan(CenterDecodingSettingEnum centerFlagScan) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.CenterFlagScan)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.CenterFlagScan+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.CenterFlagScan)) {
            this.updatedFields.add(ConfigurationFieldEnum.CenterFlagScan);
        }

        this.centerFlagScan = centerFlagScan;
    }

    public boolean isFlash() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Flash)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Flash+" is not supported on this system!");
        }

        return flash;
    }

    public void setFlash(boolean flash) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Flash)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Flash+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Flash)) {
            this.updatedFields.add(ConfigurationFieldEnum.Flash);
        }

        this.flash = flash;
    }

    public SpecificSceneEnum getScene() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Scene)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Scene+" is not supported on this system!");
        }

        return scene;
    }

    public void setScene(SpecificSceneEnum scene) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.Scene)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.Scene+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.Scene)) {
            this.updatedFields.add(ConfigurationFieldEnum.Scene);
        }

        this.scene = scene;
    }

    public boolean isRemoveGroupSeparator() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.RemoveGroupSeparator)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.RemoveGroupSeparator+" is not supported on this system!");
        }

        return removeGroupSeparator;
    }

    public void setRemoveGroupSeparator(boolean removeGroupSeparator) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.RemoveGroupSeparator)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.RemoveGroupSeparator+" is not supported on this system!");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.RemoveGroupSeparator)) {
            this.updatedFields.add(ConfigurationFieldEnum.RemoveGroupSeparator);
        }

        this.removeGroupSeparator = removeGroupSeparator;
    }

    public int getPrefixCharactersRemoved() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.PrefixCharactersRemoved)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.PrefixCharactersRemoved+" is not supported on this system!");
        }

        return prefixCharactersRemoved;
    }

    public void setPrefixCharactersRemoved(int prefixCharactersRemoved) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.PrefixCharactersRemoved)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.PrefixCharactersRemoved+" is not supported on this system!");
        }

        if(prefixCharactersRemoved < 0 || prefixCharactersRemoved > 20) {
            throw new RuntimeException("PrefixCharactersRemoved is not in range of [0, 20]");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.PrefixCharactersRemoved)) {
            this.updatedFields.add(ConfigurationFieldEnum.PrefixCharactersRemoved);
        }

        this.prefixCharactersRemoved = prefixCharactersRemoved;
    }

    public int getSuffixCharactersRemoved() {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.SuffixCharactersRemoved)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.SuffixCharactersRemoved+" is not supported on this system!");
        }

        return suffixCharactersRemoved;
    }

    public void setSuffixCharactersRemoved(int suffixCharactersRemoved) {
        if(this.unsupportedFields.contains(ConfigurationFieldEnum.SuffixCharactersRemoved)) {
            throw new RuntimeException("Field "+ConfigurationFieldEnum.SuffixCharactersRemoved+" is not supported on this system!");
        }

        if(suffixCharactersRemoved < 0 || suffixCharactersRemoved > 20) {
            throw new RuntimeException("SuffixCharactersRemoved is not in range of [0, 20]");
        }

        if(! this.updatedFields.contains(ConfigurationFieldEnum.SuffixCharactersRemoved)) {
            this.updatedFields.add(ConfigurationFieldEnum.SuffixCharactersRemoved);
        }

        this.suffixCharactersRemoved = suffixCharactersRemoved;
    }
}
