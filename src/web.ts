import { WebPlugin } from '@capacitor/core';

import type { SunmiBarcodeScannerPlugin } from './definitions';

export class SunmiBarcodeScannerWeb
  extends WebPlugin
  implements SunmiBarcodeScannerPlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
