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

export interface SetTriggerOptions {
  /**
   * Enable or disable trigger button
   *
   * @default true
   */
  enabled?: boolean;
}

export interface CreateWriteContextOptions {
  /**
   * Selects write context type you want to create
   *
   * @default [WriteContextType.Service, WriteContextType.Decoders]
   */
  type: WriteContextType|WriteContextType[],
}

export enum WriteContextType {
  /**
   * Service write context type, permits reading and writing of scanner related settings
   */
  Service = "service",

  /**
   * Decoder write context type, permits enabling or disabling of barcode symbologies, and changing its settings
   */
  Decoders = "decoders",
}

export type GetOutputTypeResponse = GetOutputTypeDisabledResponse | GetOutputTypeKeystrokeResponse | GetOutputTypeDirectFillResponse;

export interface GetOutputTypeDisabledResponse {
  /**
   * No direct output
   */
  mode: OutputMode.Disabled;
}

export interface GetOutputTypeKeystrokeResponse {
  /**
   * Virtual Keyboard output
   */
  mode: OutputMode.Keystroke;

  /**
   * Time to sleep between keystrokes
   */
  interval: number;

  /**
   * Send a tab keystroke after the barcode
   */
  tab?: boolean;

  /**
   * Send an enter keystroke after the barcode
   */
  enter?: boolean;

  /**
   * Send a space keystroke after the barcode
   *
   * Hardware support limited
   */
  space?: boolean;
}

export interface GetOutputTypeDirectFillResponse {
  /**
   * Fill in EditText directly
   */
  mode: OutputMode.DirectFill | OutputMode.DirectFillWithReplace;

  /**
   * Send a tab keystroke after the barcode
   */
  tab?: boolean;

  /**
   * Send an enter keystroke after the barcode
   */
  enter?: boolean;

  /**
   * Send a space keystroke after the barcode
   *
   * Hardware support limited
   */
  space?: boolean;

  /**
   * Convert characters into keys
   */
  asEvent?: boolean;
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

export type GetTriggerMethodResponse = GetTriggerMethodTriggerPulseResponse | GetTriggerMethodContinuousLongPressResponse;

interface GetTriggerMethodTriggerPulseResponse {
  mode: ScanMode.Trigger | ScanMode.Pulse;

  /**
   * Timeout after which the scanner will stop scanning if no barcode is detected
   */
  timeout: number;
}

interface GetTriggerMethodContinuousLongPressResponse {
  mode: ScanMode.Continuous | ScanMode.LongPress;

  /**
   * Timeout after which the scanner will stop scanning if no barcode is detected
   */
  timeout: number;

  /**
   * Time to sleep between scans
   */
  sleep: number;
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

export interface GetScanResultCodeIDResponse {
  /**
   * Selects variant of code type returned with scan result
   */
  type: ScanResultCodeIDEnum;
}

export interface SetScanResultCodeIDOptions {
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

export interface IsAdvancedFormatEnabledResponse {
  /**
   * Enable or disable advanced formatting options provided in configuration
   */
  enabled: boolean;
}

export interface SetAdvancedFormatEnabledOptions {
  /**
   * Enable or disable advanced formatting options provided in configuration
   *
   * @default true
   */
  enabled?: boolean;
}

export interface IsBeepResponse {
  /**
   * Enable or disable sound prompts on scan
   */
  enabled: boolean;
}

export interface SetBeepOptions {
  /**
   * Enable or disable sound prompts on scan
   *
   * @default true
   */
  enabled?: boolean;
}

export interface IsVibrateResponse {
  /**
   * Enable or disable vibration prompts on scan
   */
  enabled: boolean;
}

export interface SetVibrateOptions {
  /**
   * Enable or disable vibration prompts on scan
   *
   * @default true
   */
  enabled?: boolean;
}

export interface IsOutputBroadcastEnableResponse {
  /**
   * Enable or disable scan result broadcast
   */
  enabled: boolean;
}

export interface SetOutputBroadcastEnabledOutput {
  /**
   * Enable or disable scan result broadcast
   *
   * @default true
   */
  enabled?: boolean;
}

export interface GetBroadcastConfigurationResponse {
  /**
   * Intent name broadcasted when a barcode is scanned
   */
  scanned_intent: string,

  /**
   * Intent name broadcasted when scanner starts scanning
   *
   * Set to `false` to disable
   */
  start_intent: string|false,

  /**
   * Intent name broadcasted when scanner stops scanning
   *
   * Set to `false` to disable
   */
  end_intent: string|false,

  /**
   * Intent extra key for barcode plain text data in scan result intent (`scanned_intent`)
   */
  intent_data_key: string,

  /**
   * Intent extra key for barcode base64 encoded data in scan result intent (`scanned_intent`)
   */
  intent_byte_key: string
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
   * Set to `false` to disable
   *
   * @default com.sunmi.scanner.ACTION_SCAN_START
   */
  start_intent?: string|false,

  /**
   * Intent name broadcasted when scanner stops scanning
   *
   * Set to `false` to disable
   *
   * @default com.sunmi.scanner.ACTION_SCAN_END
   */
  end_intent?: string|false,

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

export interface GetOutputEncodingCodeResponse {
  /**
   * Set output encoding/character set setting
   */
  encoding: OutputEncodingCodeEnum;
}

export interface SetOutputEncodingCodeOptions {
  /**
   * Set output encoding/character set setting
   *
   * @default OutputEncodingCodeEnum.UTF8
   */
  encoding?: OutputEncodingCodeEnum;
}

export enum OutputEncodingCodeEnum {
  UTF8 = "UTF8",
  GBK = "GBK",
  ISO88591 = "ISO88591",
  SHIFTJIS = "SHIFTJIS",

  /**
   * Auto detect encoding/compatibility mode
   */
  Auto = "Auto",

  WINDOWS1256 = "WINDOWS1256",

  /**
   * Hardware support limited
   */
  WINDOWS874 = "WINDOWS874",

  /**
   * Hardware support limited
   */
  Unicode = "Unicode",

  /**
   * Hardware support limited
   */
  Big5 = "Big5",

  /**
   * Hardware support limited
   */
  ASCII = "ASCII",

  /**
   * Hardware support limited
   */
  GB2312 = "GB2312",

  /**
   * Hardware support limited
   */
  GB18030 = "GB18030",
}

export interface IsVirtualFloatingScanButtonResponse {
  /**
   * Enable or disable virtual floating scan button
   */
  enabled: boolean;
}

export interface SetVirtualFloatingScanButtonOptions {
  /**
   * Enable or disable virtual floating scan button
   *
   * @default true
   */
  enabled?: boolean;
}

export interface GetCenterFlagScanResponse {
  /**
   * Selects center point decoding mode
   */
  mode: CenterDecodingSettingEnum;
}

export interface SetCenterFlagScanOptions {
  /**
   * Selects center point decoding mode
   *
   * @default CenterDecodingSettingEnum.Disabled
   */
  mode?: CenterDecodingSettingEnum;
}

export enum CenterDecodingSettingEnum {
  Disabled = "disabled",
  CenterOnly = "center-only",

  /**
   * Hardware support limited
   */
  CenterFirst = "center-first",
}

export interface IsFlashResponse {
  /**
   * Enable or disable scanner illumination
   */
  enabled: boolean;
}

export interface SetFlashOptions {
  /**
   * Enable or disable scanner illumination
   *
   * @default true
   */
  enabled?: boolean;
}

export interface GetSceneResponse {
  /**
   * Selects scanning scene preset
   */
  scene: SpecificSceneEnum;
}

export interface SetSceneOptions {
  /**
   * Selects scanning scene preset
   *
   * @default SpecificSceneEnum.Default
   */
  scene?: SpecificSceneEnum;
}

export enum SpecificSceneEnum {
  Default = "default",
  ReflectiveDMBarcode = "reflective-dm-barcode",
  ReflectiveQRDMBarcode = "reflective-qr-dm-barcode",
  SpecialColourBarcode = "special-colour-barcode",
  DpmBarcode = "dpm-barcode",
  MobileScreenScene = "mobile-screen-scene",
}

export interface IsRemoveGroupSeparatorResponse {
  /**
   * Enable or disable the removal of group separator characters
   */
  enabled: boolean;
}

export interface SetRemoveGroupSeparatorOptions {
  /**
   * Enable or disable the removal of group separator characters
   *
   * @default true
   */
  enabled?: boolean;
}

export interface GetPrefixResponse {
  /**
   * Prefix content to be prepended to the barcode data
   *
   * When set to `false`, the prefix will be disabled
   */
  content: string|false;
}

export interface SetPrefixOptions {
  /**
   * Prefix content to be prepended to the barcode data
   *
   * When set to `false`, the prefix will be disabled
   *
   * @default false
   */
  content?: string|false;
}

export interface GetPrefixCharactersRemovedResponse {
  /**
   * Number of characters to be removed from the beginning of the barcode data
   */
  length: number;
}

export interface SetPrefixCharactersRemovedOptions {
  /**
   * Number of characters to be removed from the beginning of the barcode data
   *
   * @default 0
   */
  length?: number;
}

export interface GetSuffixResponse {
  /**
   * Suffix content to be appended to the barcode data
   *
   * When set to `false`, the suffix will be disabled
   */
  content: string|false;
}

export interface SetSuffixOptions {
  /**
   * Suffix content to be appended to the barcode data
   *
   * When set to `false`, the suffix will be disabled
   *
   * @default false
   */
  content?: string|false;
}

export interface GetSuffixCharactersRemovedResponse {
  /**
   * Number of characters to be removed from the end of the barcode data
   */
  length: number;
}

export interface SetSuffixCharactersRemovedOptions {
  /**
   * Number of characters to be removed from the end of the barcode data
   *
   * @default 0
   */
  length?: number;
}

export interface GetBarcodesListResponse {
  /**
   * List of barcodes, and its statuses.
   * Key is barcode symbology name, value is status: `true` if enabled, `false` if disabled.
   */
  list: Map<string, boolean>;
}

export interface GetBarcodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetBarcodeResponse {
  /**
   * Barcode status
   */
  enabled: boolean;
}

export interface SetBarcodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   * Barcode status
   */
  enabled: boolean;
}

export interface GetBarcodeConfigOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetBarcodeConfigResponse {
  /**
   *
   */
  checkCharMode?: number;

  /**
   *
   */
  checkCharType?: number;

  /**
   *
   */
  doubleCode?: number;

  /**
   *
   */
  formatCode?: number;

  /**
   *
   */
  inverseCode?: number;

  /**
   *
   */
  isExtendCode1?: boolean;

  /**
   *
   */
  isExtendCode2?: boolean;

  /**
   *
   */
  isExtendToCode?: boolean;

  /**
   *
   */
  isMicroCode?: boolean;

  /**
   *
   */
  isStartEndType?: boolean;

  /**
   *
   */
  isSystemCharZero?: boolean;

  /**
   *
   */
  maxLen?: number;

  /**
   *
   */
  minLen?: number;
}

export interface GetCheckCharModeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetCheckCharModeResponse {
  /**
   *
   */
  value: number;
}

export interface SetCheckCharModeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetCheckCharTypeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetCheckCharTypeResponse {
  /**
   *
   */
  value: number;
}

export interface SetCheckCharTypeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetDoubleCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetDoubleCodeResponse {
  /**
   *
   */
  value: number;
}

export interface SetDoubleCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetFormatCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetFormatCodeResponse {
  /**
   *
   */
  value: number;
}

export interface SetFormatCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetInverseCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetInverseCodeResponse {
  /**
   *
   */
  value: number;
}

export interface SetInverseCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface IsExtendCode1Options {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsExtendCode1Response {
  /**
   *
   */
  value: boolean;
}

export interface SetExtendCode1Options {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface IsExtendCode2Options {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsExtendCode2Response {
  /**
   *
   */
  value: boolean;
}

export interface SetExtendCode2Options {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface IsExtendToCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsExtendToCodeResponse {
  /**
   *
   */
  value: boolean;
}

export interface SetExtendToCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface IsMicroCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsMicroCodeResponse {
  /**
   *
   */
  value: boolean;
}

export interface SetMicroCodeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface IsStartEndTypeOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsStartEndTypeResponse {
  /**
   *
   */
  value: boolean;
}

export interface SetStartEndTypeOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface IsSystemCharZeroOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface IsSystemCharZeroResponse {
  /**
   *
   */
  value: boolean;
}

export interface SetSystemCharZeroOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: boolean;
}

export interface GetMaxLenOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetMaxLenResponse {
  /**
   *
   */
  value: number;
}

export interface SetMaxLenOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetMinLenOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetMinLenResponse {
  /**
   *
   */
  value: number;
}

export interface SetMinLenOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
}

export interface GetStartEndFormatOptions {
  /**
   * Barcode symbology name
   */
  name: string;
}

export interface GetStartEndFormatResponse {
  /**
   *
   */
  value: number;
}

export interface SetStartEndFormatOptions {
  /**
   * Barcode symbology name
   */
  name: string;

  /**
   *
   */
  value: number;
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
  createWriteContext(options?: CreateWriteContextOptions): Promise<void>;

  /**
   * Write settings to scanner
   */
  commitWriteContext(): Promise<void>;

  /**
   * Discard transaction for writing settings to scanner
   */
  discardWriteContext(): Promise<void>;

  /**
   *
   */
  getOutputType(): Promise<GetOutputTypeResponse>;

  /**
   * Set output mode
   */
  setOutputType(options: SetOutputTypeOptions): Promise<void>;

  /**
   *
   */
  getTriggerMethod(): Promise<GetTriggerMethodResponse>;

  /**
   * Set scan mode
   */
  setTriggerMethod(options: SetTriggerMethodOptions): Promise<void>;

  /**
   *
   */
  getScanResultCodeID(): Promise<GetScanResultCodeIDResponse>;

  /**
   * Selects variant of code type returned with scan result
   */
  setScanResultCodeID(options?: SetScanResultCodeIDOptions): Promise<void>;

  /**
   *
   */
  isAdvancedFormatEnabled(): Promise<IsAdvancedFormatEnabledResponse>;

  /**
   * Enable or disable advanced formatting options provided in configuration
   */
  setAdvancedFormatEnabled(options?: SetAdvancedFormatEnabledOptions): Promise<void>;

  /**
   *
   */
  isBeep(): Promise<IsBeepResponse>;

  /**
   * Enable or disable sound prompts on scan
   */
  setBeep(options?: SetBeepOptions): Promise<void>;

  /**
   *
   */
  isVibrate(): Promise<IsVibrateResponse>;

  /**
   * Enable or disable vibration prompts on scan
   */
  setVibrate(options?: SetVibrateOptions): Promise<void>;

  /**
   *
   */
  isOutputBroadcastEnabled(): Promise<IsOutputBroadcastEnableResponse>;

  /**
   * Enable or disable scan result broadcast
   */
  setOutputBroadcastEnabled(options?: SetOutputBroadcastEnabledOutput): Promise<void>;

  /**
   *
   */
  getBroadcastConfiguration(): Promise<GetBroadcastConfigurationResponse>;

  /**
   * Set broadcast configuration
   */
  setBroadcastConfiguration(options?: SetBroadcastConfigurationOptions): Promise<void>;

  /**
   *
   */
  getOutputEncodingCode(): Promise<GetOutputEncodingCodeResponse>;

  /**
   * Set output encoding/character set setting
   */
  setOutputEncodingCode(options?: SetOutputEncodingCodeOptions): Promise<void>;

  /**
   *
   */
  isVirtualFloatingScanButton(): Promise<IsVirtualFloatingScanButtonResponse>;

  /**
   * Enable or disable the virtual floating scan button
   */
  setVirtualFloatingScanButton(options?: SetVirtualFloatingScanButtonOptions): Promise<void>;

  /**
   *
   */
  getCenterFlagScan(): Promise<GetCenterFlagScanResponse>;

  /**
   * Sets center point decoding mode
   */
  setCenterFlagScan(options?: SetCenterFlagScanOptions): Promise<void>;

  /**
   *
   */
  isFlash(): Promise<IsFlashResponse>;

  /**
   * Controls scanner illumination
   *
   * Hardware support limited
   */
  setFlash(options?: SetFlashOptions): Promise<void>;

  /**
   *
   */
  getScene(): Promise<GetSceneResponse>;

  /**
   * Sets scanning scene preset
   *
   * Hardware support limited
   */
  setScene(options?: SetSceneOptions): Promise<void>;

  /**
   *
   */
  isRemoveGroupSeparator(): Promise<IsRemoveGroupSeparatorResponse>;

  /**
   * Enables or disables the removal of group separator characters
   *
   * Hardware support limited
   */
  setRemoveGroupSeparator(options?: SetRemoveGroupSeparatorOptions): Promise<void>;

  /**
   *
   */
  getPrefix(): Promise<GetPrefixResponse>;

  /**
   * Sets the prefix to be prepended to the barcode data
   */
  setPrefix(options?: SetPrefixOptions): Promise<void>;

  /**
   *
   */
  getPrefixCharactersRemoved(): Promise<GetPrefixCharactersRemovedResponse>;

  /**
   * Sets the prefix characters to be removed from the barcode data
   *
   * Hardware support limited
   */
  setPrefixCharactersRemoved(options?: SetPrefixCharactersRemovedOptions): Promise<void>;

  /**
   *
   */
  getSuffix(): Promise<GetSuffixResponse>;

  /**
   * Sets the suffix to be appended to the barcode data
   */
  setSuffix(options?: SetSuffixOptions): Promise<void>;

  /**
   *
   */
  getSuffixCharactersRemoved(): Promise<GetSuffixCharactersRemovedResponse>;

  /**
   * Sets the suffix characters to be removed from the barcode data
   *
   * Hardware support limited
   */
  setSuffixCharactersRemoved(options?: SetSuffixCharactersRemovedOptions): Promise<void>;

  /**
   *
   */
  getBarcodesList(): Promise<GetBarcodesListResponse>;

  /**
   *
   */
  getBarcode(options: GetBarcodeOptions): Promise<GetBarcodeResponse>;

  /**
   *
   */
  setBarcode(options: SetBarcodeOptions): Promise<void>;

  /**
   *
   */
  getBarcodeConfig(options: GetBarcodeConfigOptions): Promise<GetBarcodeConfigResponse>;

  /**
   *
   */
  getCheckCharMode(options: GetCheckCharModeOptions): Promise<GetCheckCharModeResponse>;

  /**
   *
   */
  setCheckCharMode(options: SetCheckCharModeOptions): Promise<void>;

  /**
   *
   */
  getCheckCharType(options: GetCheckCharTypeOptions): Promise<GetCheckCharTypeResponse>;

  /**
   *
   */
  setCheckCharType(options: SetCheckCharTypeOptions): Promise<void>;

  /**
   *
   */
  getDoubleCode(options: GetDoubleCodeOptions): Promise<GetDoubleCodeResponse>;

  /**
   *
   */
  setDoubleCode(options: SetDoubleCodeOptions): Promise<void>;

  /**
   *
   */
  getFormatCode(options: GetFormatCodeOptions): Promise<GetFormatCodeResponse>;

  /**
   *
   */
  setFormatCode(options: SetFormatCodeOptions): Promise<void>;

  /**
   *
   */
  getInverseCode(options: GetInverseCodeOptions): Promise<GetInverseCodeResponse>;

  /**
   *
   */
  setInverseCode(options: SetInverseCodeOptions): Promise<void>;

  /**
   *
   */
  isExtendCode1(options: IsExtendCode1Options): Promise<IsExtendCode1Response>;

  /**
   *
   */
  setExtendCode1(options: SetExtendCode1Options): Promise<void>;

  /**
   *
   */
  isExtendCode2(options: IsExtendCode2Options): Promise<IsExtendCode2Response>;

  /**
   *
   */
  setExtendCode2(options: SetExtendCode2Options): Promise<void>;

  /**
   *
   */
  isExtendToCode(options: IsExtendToCodeOptions): Promise<IsExtendToCodeResponse>;

  /**
   *
   */
  setExtendToCode(options: SetExtendToCodeOptions): Promise<void>;

  /**
   *
   */
  isMicroCode(options: IsMicroCodeOptions): Promise<IsMicroCodeResponse>;

  /**
   *
   */
  setMicroCode(options: SetMicroCodeOptions): Promise<void>;

  /**
   *
   */
  isStartEndType(options: IsStartEndTypeOptions): Promise<IsStartEndTypeResponse>;

  /**
   *
   */
  setStartEndType(options: SetStartEndTypeOptions): Promise<void>;

  /**
   *
   */
  isSystemCharZero(options: IsSystemCharZeroOptions): Promise<IsSystemCharZeroResponse>;

  /**
   *
   */
  setSystemCharZero(options: SetSystemCharZeroOptions): Promise<void>;

  /**
   *
   */
  getMaxLen(options: GetMaxLenOptions): Promise<GetMaxLenResponse>;

  /**
   *
   */
  setMaxLen(options: SetMaxLenOptions): Promise<void>;

  /**
   *
   */
  getMinLen(options: GetMinLenOptions): Promise<GetMinLenResponse>;

  /**
   *
   */
  setMinLen(options: SetMinLenOptions): Promise<void>;

  /**
   *
   */
  getStartEndFormat(options: GetStartEndFormatOptions): Promise<GetStartEndFormatResponse>;

  /**
   *
   */
  setStartEndFormat(options: SetStartEndFormatOptions): Promise<void>;

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