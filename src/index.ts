import { registerPlugin } from '@capacitor/core';

import type { SunmiScanHeadPlugin } from './definitions';

const SunmiScanHead = registerPlugin<SunmiScanHeadPlugin>(
  'SunmiScanHead',
  {
    web: () => import('./web').then(m => new m.SunmiScanHeadWeb()),
    ios: () => import('./web').then(m => new m.SunmiScanHeadWeb()),
  },
);

export * from './definitions';
export { SunmiScanHead };
