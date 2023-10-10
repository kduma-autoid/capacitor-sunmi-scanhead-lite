/// <reference types="@capacitor/cli" />
declare module '@capacitor/cli' {
  export interface PluginsConfig {
    SunmiScanHeadPlugin?: {
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

export interface GetScannerModelResponse {
  /**
   * Numeric identifier of the scanner model
   */
  id: number;

  /**
   * String identifier of the scanner model
   */
  name: ScannerModelName;
}

export type ScannerModelName = ScannerModel | string;

export enum ScannerModel {
  NONE = "NONE",
  SUPER_N1365_Y1825 = "SUPER_N1365_Y1825",
  NLS_2096 = "NLS_2096",
  ZEBRA_4710 = "ZEBRA_4710",
  HONEYWELL_3601 = "HONEYWELL_3601",
  HONEYWELL_6603 = "HONEYWELL_6603",
  ZEBRA_4750 = "ZEBRA_4750",
  ZEBRA_1350 = "ZEBRA_1350",
  HONEYWELL_6703 = "HONEYWELL_6703",
  HONEYWELL_3603 = "HONEYWELL_3603",
  NLS_CM47 = "NLS_CM47",
  NLS_3108 = "NLS_3108",
  ZEBRA_965 = "ZEBRA_965",
  SM_SS_1100 = "SM_SS_1100",
  NLS_CM30 = "NLS_CM30",
  HONEYWELL_4603 = "HONEYWELL_4603",
  ZEBRA_4770 = "ZEBRA_4770",
  NLS_2596 = "NLS_2596",
  SM_SS_1103 = "SM_SS_1103",
  SM_SS_1101 = "SM_SS_1101",
  HONEYWELL_5703 = "HONEYWELL_5703",
  UNKNOWN = "UNKNOWN",
}

export interface ClearConfigResponse {
  /**
   * Status of the operation
   */
  cleared: boolean;
}

export type SetOutputTypeOptions = SetOutputTypeDisabledOptions | SetOutputTypeKeystrokeOptions | SetOutputTypeDirectFillOptions;

export interface SetOutputTypeDisabledOptions {
  /**
   * No direct output
   */
  mode: OutputMode.Disabled;
}

export interface SetOutputTypeKeystrokeOptions {
  /**
   * Virtual Keyboard output
   */
  mode: OutputMode.Keystroke;

  /**
   * Time to sleep between keystrokes
   *
   * @default 0
   */
  interval?: number;

  /**
   * Send a tab keystroke after the barcode
   *
   * @default false
   */
  tab?: boolean;

  /**
   * Send an enter keystroke after the barcode
   *
   * @default true
   */
  enter?: boolean;

  /**
   * Send a space keystroke after the barcode
   *
   * Hardware support limited
   *
   * @default false
   */
  space?: boolean;
}

export interface SetOutputTypeDirectFillOptions {
  /**
   * Fill in EditText directly
   */
  mode: OutputMode.DirectFill | OutputMode.DirectFillWithReplace;

  /**
   * Send a tab keystroke after the barcode
   *
   * @default false
   */
  tab?: boolean;

  /**
   * Send an enter keystroke after the barcode
   *
   * @default true
   */
  enter?: boolean;

  /**
   * Send a space keystroke after the barcode
   *
   * Hardware support limited
   *
   * @default false
   */
  space?: boolean;

  /**
   * Convert characters into keys
   *
   * @default false
   */
  asEvent?: boolean;
}

export enum OutputMode {
  /**
   * Fill in EditText directly
   */
  DirectFill = "direct-fill",

  /**
   * Fill and overwrite in EditText directly
   */
  DirectFillWithReplace = "direct-fill-with-replace",

  /**
   * Virtual Keyboard output
   */
  Keystroke = "keystroke",

  /**
   * No direct output
   */
  Disabled = "disabled",
}

export type SetTriggerMethodOptions = SetTriggerMethodTriggerPulseOptions | SetTriggerMethodContinuousLongPressOptions;

interface SetTriggerMethodTriggerPulseOptions {
  mode: ScanMode.Trigger | ScanMode.Pulse;

  /**
   * Timeout after which the scanner will stop scanning if no barcode is detected
   *
   * @default 5000
   */
  timeout?: number;
}

interface SetTriggerMethodContinuousLongPressOptions {
  mode: ScanMode.Continuous | ScanMode.LongPress;

  /**
   * Timeout after which the scanner will stop scanning if no barcode is detected
   *
   * @default 5000
   */
  timeout?: number;

  /**
   * Time to sleep between scans
   *
   * @default 500
   */
  sleep?: number;
}

export enum ScanMode {
  /**
   * Trigger Mode: Short press to scan, and release to stop scanning
   */
  Trigger = "trigger",

  /**
   * Continuous Mode: Short press to start scanning, and short press to stop scanning
   */
  Continuous = "continuous",

  /**
   * Pulse Mode: Short press to start scanning until timeout
   */
  Pulse = "pulse",

  /**
   * Long Press Mode: Long press to scan continuously, release to stop
   *
   * Hardware support limited
   */
  LongPress = "long-press",
}

export interface SetTriggerOptions {
  /**
   * Enable or disable trigger button
   *
   * @default true
   */
  enabled?: boolean;
}

export interface setScanResultCodeIDOptions {
  /**
   * Selects variant of code type returned with scan result
   *
   * @default ScanResultCodeIDEnum.None
   */
  type?: ScanResultCodeIDEnum;
}

export enum ScanResultCodeIDEnum {
  None = "none",
  SunmiId = "sunmi-id",

  /**
   * Hardware support limited
   */
  AimId = "aim-id",

  /**
   * Hardware support limited
   */
  SymbolId = "symbol-id",
}

export interface setAdvancedFormatEnabledOptions {
  /**
   * Enable or disable advanced formatting options provided in configuration
   *
   * @default true
   */
  enabled?: boolean;
}

export interface SetBeepOptions {
  /**
   * Enable or disable sound prompts on scan
   *
   * @default true
   */
  enabled?: boolean;
}

export interface setVibrateOptions {
  /**
   * Enable or disable vibration prompts on scan
   *
   * @default true
   */
  enabled?: boolean;
}

export interface setOutputBroadcastEnabledOutput {
  /**
   * Enable or disable scan result broadcast
   *
   * @default true
   */
  enabled?: boolean;
}

export interface SetBroadcastConfigurationOptions {
  /**
   * Intent name broadcasted when a barcode is scanned
   *
   * @default com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED
   */
  scanned_intent?: string,

  /**
   * Intent name broadcasted when scanner starts scanning
   *
   * @default com.sunmi.scanner.ACTION_SCAN_START
   */
  start_intent?: string,

  /**
   * Intent name broadcasted when scanner stops scanning
   *
   * @default com.sunmi.scanner.ACTION_SCAN_END
   */
  end_intent?: string,

  /**
   * Intent extra key for barcode plain text data in scan result intent (`scanned_intent`)
   *
   * @default data
   */
  intent_data_key?: string,

  /**
   * Intent extra key for barcode base64 encoded data in scan result intent (`scanned_intent`)
   *
   * @default source_byte
   */
  intent_byte_key?: string
}

export interface SunmiScanHeadPlugin {
  /**
   * bind scan service
   */
  bindService(): Promise<void>;

  /**
   * unbind scan service
   */
  unBindService(): Promise<void>;

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
   */
  getScannerModel(): Promise<GetScannerModelResponse>;

  /**
   * Clear scanner configuration (reset to default)
   */
  clearConfig(): Promise<ClearConfigResponse>;

  /**
   * Enable or disable trigger button
   */
  setTrigger(options?: SetTriggerOptions): Promise<void>;

  /**
   * Play a beep sound
   */
  beep(): Promise<void>;

  /**
   * Vibrate
   */
  vibrate(): Promise<void>;

  /**
   * Prepares transaction for writing settings to scanner
   */
  createWriteContext(): Promise<void>;

  /**
   * Write settings to scanner
   */
  commitWriteContext(): Promise<void>;

  /**
   * Discard transaction for writing settings to scanner
   */
  discardWriteContext(): Promise<void>;

  /**
   * Set output mode
   */
  setOutputType(options: SetOutputTypeOptions): Promise<void>;

  /**
   * Set scan mode
   */
  setTriggerMethod(options: SetTriggerMethodOptions): Promise<void>;

  /**
   * Selects variant of code type returned with scan result
   */
  setScanResultCodeID(options?: setScanResultCodeIDOptions): Promise<void>;

  /**
   * Enable or disable advanced formatting options provided in configuration
   */
  setAdvancedFormatEnabled(options?: setAdvancedFormatEnabledOptions): Promise<void>;

  /**
   * Enable or disable sound prompts on scan
   */
  setBeep(options?: SetBeepOptions): Promise<void>;

  /**
   * Enable or disable vibration prompts on scan
   */
  setVibrate(options?: setVibrateOptions): Promise<void>;

  /**
   * Enable or disable scan result broadcast
   */
  setOutputBroadcastEnabled(options?: setOutputBroadcastEnabledOutput): Promise<void>;

  /**
   * Set broadcast configuration
   */
  setBroadcastConfiguration(options?: SetBroadcastConfigurationOptions): Promise<void>;

  /**
   * Listens for barcode scanner result events.
   */
  addListener(
      eventName: 'onScanResult',
      listenerFunc: OnScanResultListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listens for barcode scanner start events.
   */
  addListener(
      eventName: 'onScanStart',
      listenerFunc: OnScanStartListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Listens for barcode scanner stop events.
   */
  addListener(
      eventName: 'onScanStop',
      listenerFunc: OnScanStopListener,
  ): Promise<PluginListenerHandle> & PluginListenerHandle;

  /**
   * Removes all listeners
   */
  removeAllListeners(): Promise<void>;
}

/**
 * Callback to receive scan results broadcasted by the scanner
 */
export type OnScanResultListener = (scan: { data: string, source_bytes: string }) => void;

/**
 * Callback to receive scan start event broadcasted by the scanner
 */
export type OnScanStartListener = () => void;

/**
 * Callback to receive scan stop event broadcasted by the scanner
 */
export type OnScanStopListener = () => void;