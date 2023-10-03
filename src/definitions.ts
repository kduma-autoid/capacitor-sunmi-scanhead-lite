/// <reference types="@capacitor/cli" />
declare module '@capacitor/cli' {
  export interface PluginsConfig {
    SunmiBarcodeScannerPlugin?: {
      /**
       * Auto bind the scan service on app load
       *
       * @default true
       */
      bindOnLoad?: boolean;
    };
  }
}

import type { PluginListenerHandle } from '@capacitor/core';

export enum ScannerModel {
    UNKNOWN = 0,

    NONE = 100,

    BSM1825 = 101, // P2Lite/V2Pro/P2Pro(em1365/BSM1825)
    EM2096 = 102, // L2-newland (EM2096)
    SE4710 = 103, // L2-zabra (SE4710)
    N3601 = 104, // L2-HoneyWell (N3601)
    N6603 = 105, // L2-HoneyWell (N6603)
    SE4750 = 106, // L2-Zabra (SE4750)
    EM1350 = 107, // L2-Zabra (EM1350)
}

export interface SunmiBarcodeScannerPlugin {
  /**
   * bind scan service
   */
  bindService(): Promise<void>;

  /**
   * unbind scan service
   */
  unBindService(): Promise<void>;

  /**
   * Starts or stops scanning depending on current state of button press
   *
   * @deprecated Use `scan` and `stop` instead
   */
  // sendKeyEvent(options: { action: number, code: number }): Promise<void>;

  /**
   * Start scanner
   */
  scan(): Promise<void>;

  /**
   * Stop scanner
   */
  stop(): Promise<void>;

  /**
   * Get scanner model
   *
   * 100 → NONE
   * 101 → P2Lite/V2Pro/P2Pro(em1365/BSM1825)
   * 102 → L2-newland(EM2096)
   * 103 → L2-zabra(SE4710)
   * 104 → L2-HoneyWell(N3601)
   * 105 → L2-HoneyWell(N6603)
   * 106 → L2-Zabra(SE4750)
   * 107 → L2-Zabra(EM1350)
   */
  getScannerModel(): Promise<{ model: ScannerModel|number }>;

  /**
   * Listens for barcode scanner result events.
   */
  addListener(
      eventName: 'onScanResult',
      listenerFunc: (scan: { data: string, source_bytes: string }) => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listens for barcode scanner start events.
   */
  addListener(
      eventName: 'onScanStart',
      listenerFunc: () => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listens for barcode scanner stop events.
   */
  addListener(
      eventName: 'onScanStop',
      listenerFunc: () => void,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Removes all listeners
   */
  removeAllListeners(): Promise<void>;
}
