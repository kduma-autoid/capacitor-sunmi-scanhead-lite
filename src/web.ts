import { WebPlugin } from '@capacitor/core';

import type {ClearConfigResponse, GetScannerModelResponse, SunmiScanHeadPlugin} from './definitions';

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
}
