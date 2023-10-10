package dev.duma.android.sunmi.scanconfigurationhelper.config;

import com.sunmi.scanner.config.SunmiHelper;

import android.text.TextUtils;

import com.sunmi.scanner.ScannerService;
import com.sunmi.scanner.entity.Pair;
import com.sunmi.scanner.entity.ServiceSetting;

import java.util.ArrayList;
import java.util.Objects;

import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.CenterDecodingSettingEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ConfigurationFieldEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputEncodingCodeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.OutputTypeEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.ScanResultCodeIDEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.SpecificSceneEnum;
import dev.duma.android.sunmi.scanconfigurationhelper.config.enums.TriggerMethodEnum;

public class ServiceConfigurationConverter {
    public static ArrayList<String> toConfigurationCommands(ServiceConfiguration configuration) {
        ArrayList<String> commands = new ArrayList<>();

        if(configuration.isSupported(ConfigurationFieldEnum.OutputEncodingCode) && configuration.isUpdated(ConfigurationFieldEnum.OutputEncodingCode)) {
            commands.add(SunmiHelper.setOutCode(configuration.getOutputEncodingCode().getValue()));
        }

        if(configuration.isUpdated(ConfigurationFieldEnum.Beep) || configuration.isUpdated(ConfigurationFieldEnum.Vibrate)) {
            int beep = configuration.isSupported(ConfigurationFieldEnum.Beep) ? (configuration.isBeep() ? 1 : 0) : -1;
            int vibrate = configuration.isSupported(ConfigurationFieldEnum.Vibrate) ? (configuration.isVibrate() ? 1 : 0) : -1;
            commands.add(SunmiHelper.setTips(new int[] { beep, vibrate }));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastEnabled) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastEnabled)) {
            commands.add(SunmiHelper.setOutBroadcast(configuration.isOutputBroadcastEnabled() ? 1 : 0));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastAction) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastAction)) {
            commands.add(SunmiHelper.setOutBroadcastAction(configuration.getOutputBroadcastAction()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastDataKey) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastDataKey)) {
            commands.add(SunmiHelper.setOutBroadcastDataKey(configuration.getOutputBroadcastDataKey()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastByteKey) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastByteKey)) {
            commands.add(SunmiHelper.setOutBroadcastByteKey(configuration.getOutputBroadcastByteKey()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastStartAction) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastStartAction)) {
            String outputBroadcastStartAction = configuration.getOutputBroadcastStartAction();
            outputBroadcastStartAction = TextUtils.isEmpty(outputBroadcastStartAction) ? " " : outputBroadcastStartAction;
            commands.add(SunmiHelper.setStartDecodeBroadcastAction(outputBroadcastStartAction));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputBroadcastEndAction) && configuration.isUpdated(ConfigurationFieldEnum.OutputBroadcastEndAction)) {
            String outputBroadcastEndAction = configuration.getOutputBroadcastEndAction();
            outputBroadcastEndAction = TextUtils.isEmpty(outputBroadcastEndAction) ? " " : outputBroadcastEndAction;
            commands.add(SunmiHelper.setEndDecodeBroadcastAction(outputBroadcastEndAction));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.ScanResultCodeID) && configuration.isUpdated(ConfigurationFieldEnum.ScanResultCodeID)) {
            commands.add(SunmiHelper.setSetOutCodeID(configuration.getScanResultCodeID().getValue()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.Scene) && configuration.isUpdated(ConfigurationFieldEnum.Scene)) {
            commands.add(SunmiHelper.setSetScanSpecificScene(configuration.getScene().getValue()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputType) && configuration.isUpdated(ConfigurationFieldEnum.OutputType)) {
            commands.add(SunmiHelper.setOutType(configuration.getOutputType().getValue()));
        }

        if(configuration.isUpdated(ConfigurationFieldEnum.AddReturn) || configuration.isUpdated(ConfigurationFieldEnum.AddSpace) || configuration.isUpdated(ConfigurationFieldEnum.AddTab) || configuration.isUpdated(ConfigurationFieldEnum.AsEvents)) {
            int addTab = configuration.isSupported(ConfigurationFieldEnum.AddTab) ? (configuration.isAddTab() ? 1 : 0) : -1;
            int addReturn = configuration.isSupported(ConfigurationFieldEnum.AddReturn) ? (configuration.isAddReturn() ? 1 : 0) : -1;
            int asEvents = configuration.isSupported(ConfigurationFieldEnum.AsEvents) ? (configuration.isAsEvents() ? 1 : 0) : -1;

            if(configuration.isSupported(ConfigurationFieldEnum.AddSpace)) {
                int addSpace = configuration.isAddSpace() ? 1 : 0;
                commands.add(SunmiHelper.setOutAutoAdd(new int[]{ addTab, addReturn, asEvents, addSpace }));
            } else {
                commands.add(SunmiHelper.setOutAutoAdd(new int[]{ addTab, addReturn, asEvents }));
            }
        }

        if(configuration.isSupported(ConfigurationFieldEnum.OutputCharacterInterval) && configuration.isUpdated(ConfigurationFieldEnum.OutputCharacterInterval)) {
            commands.add(SunmiHelper.setOutCharInterval(configuration.getOutputCharacterInterval()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.Prefix) && configuration.isUpdated(ConfigurationFieldEnum.Prefix)) {
            String prefix = configuration.getPrefix();
            commands.add(SunmiHelper.setPrefix(prefix == null ? 0 : 1));
            commands.add(SunmiHelper.setPrefixContext(prefix == null ? ScannerService.FIX_NULL : prefix));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.Suffix) && configuration.isUpdated(ConfigurationFieldEnum.Suffix)) {
            String suffix = configuration.getSuffix();
            commands.add(SunmiHelper.setSuffix(suffix == null ? 0 : 1));
            commands.add(SunmiHelper.setSuffixContext(suffix == null ? ScannerService.FIX_NULL : suffix));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.RemoveGroupSeparator) && configuration.isUpdated(ConfigurationFieldEnum.RemoveGroupSeparator)) {
            commands.add(SunmiHelper.setRemoveGroupChar(configuration.isRemoveGroupSeparator() ? 1 : 0));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.TriggerMethod) && configuration.isUpdated(ConfigurationFieldEnum.TriggerMethod)) {
            int triggerMethod = configuration.getTriggerMethod().getValue();
            commands.add(SunmiHelper.setTriggerMethod(triggerMethod));
            commands.add(SunmiHelper.setScanTriggerModel(triggerMethod));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.PrefixCharactersRemoved) && configuration.isUpdated(ConfigurationFieldEnum.PrefixCharactersRemoved)) {
            commands.add(SunmiHelper.setPrefixCount(configuration.getPrefixCharactersRemoved()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.SuffixCharactersRemoved) && configuration.isUpdated(ConfigurationFieldEnum.SuffixCharactersRemoved)) {
            commands.add(SunmiHelper.setSuffixCount(configuration.getSuffixCharactersRemoved()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.ScanTriggerTimeOut) && configuration.isUpdated(ConfigurationFieldEnum.ScanTriggerTimeOut)) {
            int scanTriggerTimeOut = configuration.getScanTriggerTimeOut();
            commands.add(SunmiHelper.setScanTriggerTimeOut(scanTriggerTimeOut));

            // TODO: Check why it is done like that
            if(configuration.isSupported(ConfigurationFieldEnum.TriggerMethod) && configuration.getTriggerMethod() == TriggerMethodEnum.Pulse) {
                commands.add(SunmiHelper.setTriggerOverTime(scanTriggerTimeOut));
            } else {
                commands.add(SunmiHelper.setTriggerOverTime(5000));
            }
        }

        if(configuration.isSupported(ConfigurationFieldEnum.TriggerContinuousTime) && configuration.isUpdated(ConfigurationFieldEnum.TriggerContinuousTime)) {
            commands.add(SunmiHelper.setTriggerContinuousTime(configuration.getTriggerContinuousTime()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.CenterFlagScan) && configuration.isUpdated(ConfigurationFieldEnum.CenterFlagScan)) {
            commands.add(SunmiHelper.setCenterFlagScan(configuration.getCenterFlagScan().getValue()));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.AdvancedFormatEnabled) && configuration.isUpdated(ConfigurationFieldEnum.AdvancedFormatEnabled)) {
            commands.add(SunmiHelper.setAdvancedFormat(configuration.isAdvancedFormatEnabled() ? 1 : 0));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.Flash) && configuration.isUpdated(ConfigurationFieldEnum.Flash)) {
            commands.add(SunmiHelper.setFlashControl(configuration.isFlash() ? 1 : 0));
        }

        if(configuration.isSupported(ConfigurationFieldEnum.VirtualFloatingScanButton) && configuration.isUpdated(ConfigurationFieldEnum.VirtualFloatingScanButton)) {
            commands.add(SunmiHelper.setScanTrigger(new int[] { configuration.isVirtualFloatingScanButton() ? 1 : 0 }));
        }

        // TODO: Add support for Advanced Formats configuration
        // if(configuration.isSupported(ConfigurationFieldEnum.AdvancedFormat) && configuration.isUpdated(ConfigurationFieldEnum.AdvancedFormat)) {
        //     ArrayList<Pair> advancedFormats = configuration.getAdvancedFormat();
        //     commands.add(SunmiHelper.setAdvancedFormatClear(1));
        //     for (Pair next : advancedFormats) {
        //         commands.add(SunmiHelper.setAdvancedFormatAdd(new String[]{next.first, next.second}));
        //     }
        // }

        return commands;
    }

    public static ServiceConfiguration fromServiceSetting(ServiceSetting serviceSetting, ArrayList<Pair> advancedFormats) {
        ServiceConfiguration configuration = new ServiceConfiguration();

        configuration.advancedFormat = advancedFormats;

        if(serviceSetting.scanExpSwitch == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Flash);
        } else {
            configuration.flash = serviceSetting.scanExpSwitch == 1;
        }

        if(serviceSetting.specificScene == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Scene);
        } else {
            configuration.scene = switch(serviceSetting.specificScene) {
                default -> SpecificSceneEnum.Default;
                case 1 -> SpecificSceneEnum.ReflectiveDMbarcode;
                case 2 -> SpecificSceneEnum.ReflectiveQRDMbarcode;
                case 3 -> SpecificSceneEnum.SpecialColourBarcode;
                case 4 -> SpecificSceneEnum.DpmBarcode;
                case 5 -> SpecificSceneEnum.MobileScreenScene;
            };
        }

        if(serviceSetting.mRemoveGroupChar == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.RemoveGroupSeparator);
        } else {
            configuration.removeGroupSeparator = serviceSetting.mRemoveGroupChar == 1;
        }

        if(serviceSetting.mPrefixCount == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.PrefixCharactersRemoved);
        } else {
            configuration.prefixCharactersRemoved = serviceSetting.mPrefixCount;
        }

        if(serviceSetting.mSuffixCount == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.SuffixCharactersRemoved);
        } else {
            configuration.suffixCharactersRemoved = serviceSetting.mSuffixCount;
        }

        if(serviceSetting.mCenterFlagScan == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.CenterFlagScan);
        } else {
            configuration.centerFlagScan = switch (serviceSetting.mCenterFlagScan) {
                default -> CenterDecodingSettingEnum.Disabled;
                case 1 -> CenterDecodingSettingEnum.CenterOnly;
                case 2 -> CenterDecodingSettingEnum.CenterFirst;
            };
        }

        if(serviceSetting.mTrigger.length == 0 || serviceSetting.mTrigger[0] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.VirtualFloatingScanButton);
        } else {
            configuration.virtualFloatingScanButton = serviceSetting.mTrigger[0] == 1;
        }

        if(serviceSetting.mAdvancedFormat == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.AdvancedFormatEnabled);
        } else {
            configuration.advancedFormatEnabled = serviceSetting.mAdvancedFormat == 1;
        }

        if(serviceSetting.mOutBroadcast == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastEnabled);
        } else {
            configuration.outputBroadcastEnabled = serviceSetting.mOutBroadcast == 1;
        }

        if(serviceSetting.mTips.length <= 1 || serviceSetting.mTips[1] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Vibrate);
        } else {
            configuration.vibrate = serviceSetting.mTips[1] == 1;
        }

        if(serviceSetting.mTips.length == 0 || serviceSetting.mTips[0] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Beep);
        } else {
            configuration.beep = serviceSetting.mTips[0] == 1;
        }

        if(serviceSetting.mTriggerMethod == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.TriggerMethod);
        } else {
            configuration.triggerMethod = switch (serviceSetting.mTriggerMethod) {
                default -> TriggerMethodEnum.Trigger;
                case 1 -> TriggerMethodEnum.Continuous;
                case 2 -> TriggerMethodEnum.Pulse;
                case 3 -> TriggerMethodEnum.LongPress;
            };
        }

        if(serviceSetting.mOutCodeID == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.ScanResultCodeID);
        } else {
            configuration.scanResultCodeID = switch (serviceSetting.mOutCodeID) {
                default -> ScanResultCodeIDEnum.None;
                case 1 -> ScanResultCodeIDEnum.SunmiId;
                case 2 -> ScanResultCodeIDEnum.AimId;
                case 3 -> ScanResultCodeIDEnum.SymbolId;
            };
        }

        if(serviceSetting.mOutType == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputType);
        } else {
            configuration.outputType = switch (serviceSetting.mOutType) {
                case 0 -> OutputTypeEnum.DirectFill;
                case 1 -> OutputTypeEnum.DirectFillWithReplace;
                default -> OutputTypeEnum.Keystroke;
                case 3 -> OutputTypeEnum.Disabled;
            };
        }

        if(serviceSetting.mOutCodeCharSet == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputEncodingCode);
        } else {
            configuration.outputEncodingCode = switch (serviceSetting.mOutCodeCharSet) {
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
        }

        if(serviceSetting.mTriggerTimeOut == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.ScanTriggerTimeOut);
        } else {
            configuration.scanTriggerTimeOut = serviceSetting.mTriggerTimeOut;
        }

        if(serviceSetting.mContinuousTime == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.TriggerContinuousTime);
        } else {
            configuration.triggerContinuousTime = serviceSetting.mContinuousTime;
        }

        if(serviceSetting.mOutCharInterval == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputCharacterInterval);
        } else {
            configuration.outputCharacterInterval = serviceSetting.mOutCharInterval;
        }

        if(serviceSetting.mPrefix == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Prefix);
        } else if(serviceSetting.mPrefix == 1) {
            configuration.prefix = serviceSetting.mPrefixContext;
        } else {
            configuration.prefix = null;
        }

        if(serviceSetting.mSuffix == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.Suffix);
        } else if(serviceSetting.mSuffix == 1) {
            configuration.suffix = serviceSetting.mSuffixContext;
        } else {
            configuration.suffix = null;
        }

        if(serviceSetting.mOutAutoAdd.length <= 3 || serviceSetting.mOutAutoAdd[3] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.AddSpace);
        } else {
            configuration.addSpace = serviceSetting.mOutAutoAdd[3] == 1;
        }

        if(serviceSetting.mOutAutoAdd.length <= 2 || serviceSetting.mOutAutoAdd[2] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.AsEvents);
        } else {
            configuration.asEvents = serviceSetting.mOutAutoAdd[2] == 1;
        }

        if(serviceSetting.mOutAutoAdd.length <= 1 || serviceSetting.mOutAutoAdd[1] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.AddReturn);
        } else {
            configuration.addReturn = serviceSetting.mOutAutoAdd[1] == 1;
        }

        if(serviceSetting.mOutAutoAdd.length == 0 || serviceSetting.mOutAutoAdd[0] == -1) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.AddTab);
        } else {
            configuration.addTab = serviceSetting.mOutAutoAdd[0] == 1;
        }

        if(Objects.equals(serviceSetting.mBroadcastAction, "-1")) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastAction);
        } else {
            configuration.outputBroadcastAction = serviceSetting.mBroadcastAction;
        }

        if(Objects.equals(serviceSetting.mDataKey, "-1")) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastDataKey);
        } else {
            configuration.outputBroadcastDataKey = serviceSetting.mDataKey;
        }

        if(Objects.equals(serviceSetting.mByteKey, "-1")) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastByteKey);
        } else {
            configuration.outputBroadcastByteKey = serviceSetting.mByteKey;
        }

        if(Objects.equals(serviceSetting.mStartDecodeAction, "-1")) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastStartAction);
        } else {
            configuration.outputBroadcastStartAction = serviceSetting.mStartDecodeAction;
        }

        if(Objects.equals(serviceSetting.mEndDecodeAction, "-1")) {
            configuration.unsupportedFields.add(ConfigurationFieldEnum.OutputBroadcastEndAction);
        } else {
            configuration.outputBroadcastEndAction = serviceSetting.mEndDecodeAction;
        }

        // configuration.triggerOverTime = null;

        return configuration;
    }
}
