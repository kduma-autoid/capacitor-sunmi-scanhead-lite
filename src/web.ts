import { WebPlugin } from '@capacitor/core';

import type { ScannerModelName, SunmiScanHeadPlugin } from './definitions';

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

  sendKeyEvent(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  stop(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getScannerModel(): Promise<{ model: number, name: ScannerModelName }> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBroadcast(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setBroadcastConfiguration(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setOutputMode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setReturnCodeType(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setScanMode(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setTrigger(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  clearConfig(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setPromptSettings(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  setAdvancedFormat(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  beep(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  vibrate(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }
}
