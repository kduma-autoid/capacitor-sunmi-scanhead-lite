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

  stop(): Promise<void> {
    throw this.unimplemented('Not implemented on web.');
  }

  getScannerModel(): Promise<{ id: number, name: ScannerModelName }> {
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

  clearConfig(): Promise<{ cleared: boolean; }> {
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
}
