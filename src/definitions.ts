export interface SunmiBarcodeScannerPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
