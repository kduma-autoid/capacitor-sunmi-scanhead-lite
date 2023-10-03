import { WebPlugin } from '@capacitor/core';

import type { SunmiBarcodeScannerPlugin } from './definitions';

export class SunmiBarcodeScannerWeb
  extends WebPlugin
  implements SunmiBarcodeScannerPlugin
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

  getScannerModel(): Promise<{ model: number; }> {
    throw this.unimplemented('Not implemented on web.');
  }
}
