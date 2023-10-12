import { WebPlugin } from '@capacitor/core';

import type {
  ClearConfigResponse,
  IsAdvancedFormatEnabledResponse,
  GetBarcodeConfigResponse,
  GetBarcodeResponse,
  GetBarcodesListResponse,
  IsBeepResponse,
  GetBroadcastConfigurationResponse,
  GetCenterFlagScanResponse,
  GetCheckCharModeResponse,
  GetCheckCharTypeResponse,
  GetDoubleCodeResponse,
  IsFlashResponse,
  GetFormatCodeResponse,
  GetInverseCodeResponse,
  GetMaxLenResponse,
  GetMinLenResponse,
  IsOutputBroadcastEnableResponse,
  GetOutputEncodingCodeResponse,
  GetOutputTypeResponse,
  GetPrefixCharactersRemovedResponse,
  GetPrefixResponse,
  IsRemoveGroupSeparatorResponse,
  GetScannerModelResponse,
  GetScanResultCodeIDResponse,
  GetSceneResponse,
  GetStartEndFormatResponse,
  GetSuffixCharactersRemovedResponse,
  GetSuffixResponse,
  GetTriggerMethodResponse,
  IsVibrateResponse,
  IsVirtualFloatingScanButtonResponse,
  IsExtendCode1Response,
  IsExtendCode2Response,
  IsExtendToCodeResponse,
  IsMicroCodeResponse,
  IsStartEndTypeResponse,
  IsSystemCharZeroResponse,
  SunmiScanHeadPlugin,
  GetAdvancedFormatEnabledResponse
} from './definitions';

export class SunmiScanHeadWeb
  extends WebPlugin
  implements SunmiScanHeadPlugin
{
  bindService(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  unBindService(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  scan(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  stop(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getScannerModel(): Promise<GetScannerModelResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  setOutputBroadcastEnabled(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBroadcastConfiguration(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setOutputType(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setScanResultCodeID(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setTriggerMethod(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setTrigger(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  clearConfig(): Promise<ClearConfigResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  createWriteContext(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  commitWriteContext(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  discardWriteContext(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBeep(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setVibrate(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setAdvancedFormatEnabled(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  beep(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  vibrate(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setOutputEncodingCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setVirtualFloatingScanButton(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setCenterFlagScan(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setFlash(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setScene(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setRemoveGroupSeparator(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setPrefix(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setPrefixCharactersRemoved(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setSuffix(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setSuffixCharactersRemoved(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getBarcode(): Promise<GetBarcodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getBarcodesList(): Promise<GetBarcodesListResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getCheckCharMode(): Promise<GetCheckCharModeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getCheckCharType(): Promise<GetCheckCharTypeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getDoubleCode(): Promise<GetDoubleCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getFormatCode(): Promise<GetFormatCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getInverseCode(): Promise<GetInverseCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getMaxLen(): Promise<GetMaxLenResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getMinLen(): Promise<GetMinLenResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getStartEndFormat(): Promise<GetStartEndFormatResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isExtendCode1(): Promise<IsExtendCode1Response> {
    throw this.unimplemented('Not implemented on web.');
  }

  isExtendCode2(): Promise<IsExtendCode2Response> {
    throw this.unimplemented('Not implemented on web.');
  }

  isExtendToCode(): Promise<IsExtendToCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isMicroCode(): Promise<IsMicroCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isStartEndType(): Promise<IsStartEndTypeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isSystemCharZero(): Promise<IsSystemCharZeroResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBarcode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setCheckCharMode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setCheckCharType(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setDoubleCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setExtendCode1(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setExtendCode2(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setExtendToCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setFormatCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setInverseCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setMaxLen(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setMicroCode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setMinLen(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setStartEndFormat(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setStartEndType(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setSystemCharZero(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getBarcodeConfig(): Promise<GetBarcodeConfigResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isAdvancedFormatEnabled(): Promise<IsAdvancedFormatEnabledResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isBeep(): Promise<IsBeepResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getBroadcastConfiguration(): Promise<GetBroadcastConfigurationResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getCenterFlagScan(): Promise<GetCenterFlagScanResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isFlash(): Promise<IsFlashResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isOutputBroadcastEnabled(): Promise<IsOutputBroadcastEnableResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getOutputEncodingCode(): Promise<GetOutputEncodingCodeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getOutputType(): Promise<GetOutputTypeResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getPrefix(): Promise<GetPrefixResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getPrefixCharactersRemoved(): Promise<GetPrefixCharactersRemovedResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isRemoveGroupSeparator(): Promise<IsRemoveGroupSeparatorResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getScanResultCodeID(): Promise<GetScanResultCodeIDResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getScene(): Promise<GetSceneResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getSuffix(): Promise<GetSuffixResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getSuffixCharactersRemoved(): Promise<GetSuffixCharactersRemovedResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  getTriggerMethod(): Promise<GetTriggerMethodResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isVibrate(): Promise<IsVibrateResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  isVirtualFloatingScanButton(): Promise<IsVirtualFloatingScanButtonResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  addAdvancedFormat(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  clearAdvancedFormats(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getAdvancedFormats(): Promise<GetAdvancedFormatEnabledResponse> {
    throw this.unimplemented('Not implemented on web.');
  }

  removeAdvancedFormat(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setAdvancedFormats(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  updateAdvancedFormat(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }
}
