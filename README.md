# @kduma-autoid/capacitor-sunmi-scanhead

Sunmi Scan Head bindings for Capacitor

## Install

```bash
npm install @kduma-autoid/capacitor-sunmi-scanhead
npx cap sync
```
## Configuration

You can disable auto binding of the service by setting `bindOnLoad` to `false` in the plugin configuration in `capacitor.config.ts`.

```typescript
/// <reference types="@kduma-autoid/capacitor-sunmi-scanhead" />
import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: "com.company.app",
  ...
  plugins: {
    SunmiScanHead: {
      bindOnLoad: true
    }
  }
}
export default config;
```

## API

<docgen-index>

* [`bindService()`](#bindservice)
* [`unBindService()`](#unbindservice)
* [`scan()`](#scan)
* [`stop()`](#stop)
* [`getScannerModel()`](#getscannermodel)
* [`clearConfig()`](#clearconfig)
* [`setTrigger(...)`](#settrigger)
* [`beep()`](#beep)
* [`vibrate()`](#vibrate)
* [`createWriteContext()`](#createwritecontext)
* [`commitWriteContext()`](#commitwritecontext)
* [`discardWriteContext()`](#discardwritecontext)
* [`setOutputType(...)`](#setoutputtype)
* [`setTriggerMethod(...)`](#settriggermethod)
* [`setScanResultCodeID(...)`](#setscanresultcodeid)
* [`setAdvancedFormatEnabled(...)`](#setadvancedformatenabled)
* [`setBeep(...)`](#setbeep)
* [`setVibrate(...)`](#setvibrate)
* [`setOutputBroadcastEnabled(...)`](#setoutputbroadcastenabled)
* [`setBroadcastConfiguration(...)`](#setbroadcastconfiguration)
* [`addListener('onScanResult', ...)`](#addlisteneronscanresult)
* [`addListener('onScanStart', ...)`](#addlisteneronscanstart)
* [`addListener('onScanStop', ...)`](#addlisteneronscanstop)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)
* [Type Aliases](#type-aliases)
* [Enums](#enums)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### bindService()

```typescript
bindService() => Promise<void>
```

bind scan service

--------------------


### unBindService()

```typescript
unBindService() => Promise<void>
```

unbind scan service

--------------------


### scan()

```typescript
scan() => Promise<void>
```

Start scanner

--------------------


### stop()

```typescript
stop() => Promise<void>
```

Stop scanner

--------------------


### getScannerModel()

```typescript
getScannerModel() => Promise<GetScannerModelResponse>
```

Get scanner model

**Returns:** <code>Promise&lt;<a href="#getscannermodelresponse">GetScannerModelResponse</a>&gt;</code>

--------------------


### clearConfig()

```typescript
clearConfig() => Promise<ClearConfigResponse>
```

Clear scanner configuration (reset to default)

**Returns:** <code>Promise&lt;<a href="#clearconfigresponse">ClearConfigResponse</a>&gt;</code>

--------------------


### setTrigger(...)

```typescript
setTrigger(options?: SetTriggerOptions | undefined) => Promise<void>
```

Enable or disable trigger button

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#settriggeroptions">SetTriggerOptions</a></code> |

--------------------


### beep()

```typescript
beep() => Promise<void>
```

Play a beep sound

--------------------


### vibrate()

```typescript
vibrate() => Promise<void>
```

Vibrate

--------------------


### createWriteContext()

```typescript
createWriteContext() => Promise<void>
```

Prepares transaction for writing settings to scanner

--------------------


### commitWriteContext()

```typescript
commitWriteContext() => Promise<void>
```

Write settings to scanner

--------------------


### discardWriteContext()

```typescript
discardWriteContext() => Promise<void>
```

Discard transaction for writing settings to scanner

--------------------


### setOutputType(...)

```typescript
setOutputType(options: SetOutputTypeOptions) => Promise<void>
```

Set output mode

| Param         | Type                                                                  |
| ------------- | --------------------------------------------------------------------- |
| **`options`** | <code><a href="#setoutputtypeoptions">SetOutputTypeOptions</a></code> |

--------------------


### setTriggerMethod(...)

```typescript
setTriggerMethod(options: SetTriggerMethodOptions) => Promise<void>
```

Set scan mode

| Param         | Type                                                                        |
| ------------- | --------------------------------------------------------------------------- |
| **`options`** | <code><a href="#settriggermethodoptions">SetTriggerMethodOptions</a></code> |

--------------------


### setScanResultCodeID(...)

```typescript
setScanResultCodeID(options?: setScanResultCodeIDOptions | undefined) => Promise<void>
```

Selects variant of code type returned with scan result

| Param         | Type                                                                              |
| ------------- | --------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setscanresultcodeidoptions">setScanResultCodeIDOptions</a></code> |

--------------------


### setAdvancedFormatEnabled(...)

```typescript
setAdvancedFormatEnabled(options?: setAdvancedFormatEnabledOptions | undefined) => Promise<void>
```

Enable or disable advanced formatting options provided in configuration

| Param         | Type                                                                                        |
| ------------- | ------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setadvancedformatenabledoptions">setAdvancedFormatEnabledOptions</a></code> |

--------------------


### setBeep(...)

```typescript
setBeep(options?: SetBeepOptions | undefined) => Promise<void>
```

Enable or disable sound prompts on scan

| Param         | Type                                                      |
| ------------- | --------------------------------------------------------- |
| **`options`** | <code><a href="#setbeepoptions">SetBeepOptions</a></code> |

--------------------


### setVibrate(...)

```typescript
setVibrate(options?: setVibrateOptions | undefined) => Promise<void>
```

Enable or disable vibration prompts on scan

| Param         | Type                                                            |
| ------------- | --------------------------------------------------------------- |
| **`options`** | <code><a href="#setvibrateoptions">setVibrateOptions</a></code> |

--------------------


### setOutputBroadcastEnabled(...)

```typescript
setOutputBroadcastEnabled(options?: setOutputBroadcastEnabledOutput | undefined) => Promise<void>
```

Enable or disable scan result broadcast

| Param         | Type                                                                                        |
| ------------- | ------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setoutputbroadcastenabledoutput">setOutputBroadcastEnabledOutput</a></code> |

--------------------


### setBroadcastConfiguration(...)

```typescript
setBroadcastConfiguration(options?: SetBroadcastConfigurationOptions | undefined) => Promise<void>
```

Set broadcast configuration

| Param         | Type                                                                                          |
| ------------- | --------------------------------------------------------------------------------------------- |
| **`options`** | <code><a href="#setbroadcastconfigurationoptions">SetBroadcastConfigurationOptions</a></code> |

--------------------


### addListener('onScanResult', ...)

```typescript
addListener(eventName: 'onScanResult', listenerFunc: OnScanResultListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner result events.

| Param              | Type                                                                  |
| ------------------ | --------------------------------------------------------------------- |
| **`eventName`**    | <code>'onScanResult'</code>                                           |
| **`listenerFunc`** | <code><a href="#onscanresultlistener">OnScanResultListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onScanStart', ...)

```typescript
addListener(eventName: 'onScanStart', listenerFunc: OnScanStartListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner start events.

| Param              | Type                                                                |
| ------------------ | ------------------------------------------------------------------- |
| **`eventName`**    | <code>'onScanStart'</code>                                          |
| **`listenerFunc`** | <code><a href="#onscanstartlistener">OnScanStartListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onScanStop', ...)

```typescript
addListener(eventName: 'onScanStop', listenerFunc: OnScanStopListener) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner stop events.

| Param              | Type                                                              |
| ------------------ | ----------------------------------------------------------------- |
| **`eventName`**    | <code>'onScanStop'</code>                                         |
| **`listenerFunc`** | <code><a href="#onscanstoplistener">OnScanStopListener</a></code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Removes all listeners

--------------------


### Interfaces


#### GetScannerModelResponse

| Prop       | Type                                                          | Description                             |
| ---------- | ------------------------------------------------------------- | --------------------------------------- |
| **`id`**   | <code>number</code>                                           | Numeric identifier of the scanner model |
| **`name`** | <code><a href="#scannermodelname">ScannerModelName</a></code> | String identifier of the scanner model  |


#### ClearConfigResponse

| Prop          | Type                 | Description             |
| ------------- | -------------------- | ----------------------- |
| **`cleared`** | <code>boolean</code> | Status of the operation |


#### SetTriggerOptions

| Prop          | Type                 | Description                      | Default           |
| ------------- | -------------------- | -------------------------------- | ----------------- |
| **`enabled`** | <code>boolean</code> | Enable or disable trigger button | <code>true</code> |


#### SetOutputTypeDisabledOptions

| Prop       | Type                                                       | Description      |
| ---------- | ---------------------------------------------------------- | ---------------- |
| **`mode`** | <code><a href="#outputmode">OutputMode.Disabled</a></code> | No direct output |


#### SetOutputTypeKeystrokeOptions

| Prop           | Type                                                        | Description                                                       | Default            |
| -------------- | ----------------------------------------------------------- | ----------------------------------------------------------------- | ------------------ |
| **`mode`**     | <code><a href="#outputmode">OutputMode.Keystroke</a></code> | Virtual Keyboard output                                           |                    |
| **`interval`** | <code>number</code>                                         | Time to sleep between keystrokes                                  | <code>0</code>     |
| **`tab`**      | <code>boolean</code>                                        | Send a tab keystroke after the barcode                            | <code>false</code> |
| **`enter`**    | <code>boolean</code>                                        | Send an enter keystroke after the barcode                         | <code>true</code>  |
| **`space`**    | <code>boolean</code>                                        | Send a space keystroke after the barcode Hardware support limited | <code>false</code> |


#### SetOutputTypeDirectFillOptions

| Prop          | Type                                                                                                                       | Description                                                       | Default            |
| ------------- | -------------------------------------------------------------------------------------------------------------------------- | ----------------------------------------------------------------- | ------------------ |
| **`mode`**    | <code><a href="#outputmode">OutputMode.DirectFill</a> \| <a href="#outputmode">OutputMode.DirectFillWithReplace</a></code> | Fill in EditText directly                                         |                    |
| **`tab`**     | <code>boolean</code>                                                                                                       | Send a tab keystroke after the barcode                            | <code>false</code> |
| **`enter`**   | <code>boolean</code>                                                                                                       | Send an enter keystroke after the barcode                         | <code>true</code>  |
| **`space`**   | <code>boolean</code>                                                                                                       | Send a space keystroke after the barcode Hardware support limited | <code>false</code> |
| **`asEvent`** | <code>boolean</code>                                                                                                       | Convert characters into keys                                      | <code>false</code> |


#### SetTriggerMethodTriggerPulseOptions

| Prop          | Type                                                                                            | Description                                                                  | Default           |
| ------------- | ----------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------- | ----------------- |
| **`mode`**    | <code><a href="#scanmode">ScanMode.Trigger</a> \| <a href="#scanmode">ScanMode.Pulse</a></code> |                                                                              |                   |
| **`timeout`** | <code>number</code>                                                                             | Timeout after which the scanner will stop scanning if no barcode is detected | <code>5000</code> |


#### SetTriggerMethodContinuousLongPressOptions

| Prop          | Type                                                                                                   | Description                                                                  | Default           |
| ------------- | ------------------------------------------------------------------------------------------------------ | ---------------------------------------------------------------------------- | ----------------- |
| **`mode`**    | <code><a href="#scanmode">ScanMode.Continuous</a> \| <a href="#scanmode">ScanMode.LongPress</a></code> |                                                                              |                   |
| **`timeout`** | <code>number</code>                                                                                    | Timeout after which the scanner will stop scanning if no barcode is detected | <code>5000</code> |
| **`sleep`**   | <code>number</code>                                                                                    | Time to sleep between scans                                                  | <code>500</code>  |


#### setScanResultCodeIDOptions

| Prop       | Type                                                                  | Description                                            | Default                                |
| ---------- | --------------------------------------------------------------------- | ------------------------------------------------------ | -------------------------------------- |
| **`type`** | <code><a href="#scanresultcodeidenum">ScanResultCodeIDEnum</a></code> | Selects variant of code type returned with scan result | <code>ScanResultCodeIDEnum.None</code> |


#### setAdvancedFormatEnabledOptions

| Prop          | Type                 | Description                                                             | Default           |
| ------------- | -------------------- | ----------------------------------------------------------------------- | ----------------- |
| **`enabled`** | <code>boolean</code> | Enable or disable advanced formatting options provided in configuration | <code>true</code> |


#### SetBeepOptions

| Prop          | Type                 | Description                             | Default           |
| ------------- | -------------------- | --------------------------------------- | ----------------- |
| **`enabled`** | <code>boolean</code> | Enable or disable sound prompts on scan | <code>true</code> |


#### setVibrateOptions

| Prop          | Type                 | Description                                 | Default           |
| ------------- | -------------------- | ------------------------------------------- | ----------------- |
| **`enabled`** | <code>boolean</code> | Enable or disable vibration prompts on scan | <code>true</code> |


#### setOutputBroadcastEnabledOutput

| Prop          | Type                 | Description                             | Default           |
| ------------- | -------------------- | --------------------------------------- | ----------------- |
| **`enabled`** | <code>boolean</code> | Enable or disable scan result broadcast | <code>true</code> |


#### SetBroadcastConfigurationOptions

| Prop                  | Type                | Description                                                                               | Default                                                  |
| --------------------- | ------------------- | ----------------------------------------------------------------------------------------- | -------------------------------------------------------- |
| **`scanned_intent`**  | <code>string</code> | Intent name broadcasted when a barcode is scanned                                         | <code>com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED</code> |
| **`start_intent`**    | <code>string</code> | Intent name broadcasted when scanner starts scanning                                      | <code>com.sunmi.scanner.ACTION_SCAN_START</code>         |
| **`end_intent`**      | <code>string</code> | Intent name broadcasted when scanner stops scanning                                       | <code>com.sunmi.scanner.ACTION_SCAN_END</code>           |
| **`intent_data_key`** | <code>string</code> | Intent extra key for barcode plain text data in scan result intent (`scanned_intent`)     | <code>data</code>                                        |
| **`intent_byte_key`** | <code>string</code> | Intent extra key for barcode base64 encoded data in scan result intent (`scanned_intent`) | <code>source_byte</code>                                 |


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### ScannerModelName

<code><a href="#scannermodel">ScannerModel</a> | string</code>


#### SetOutputTypeOptions

<code><a href="#setoutputtypedisabledoptions">SetOutputTypeDisabledOptions</a> | <a href="#setoutputtypekeystrokeoptions">SetOutputTypeKeystrokeOptions</a> | <a href="#setoutputtypedirectfilloptions">SetOutputTypeDirectFillOptions</a></code>


#### SetTriggerMethodOptions

<code><a href="#settriggermethodtriggerpulseoptions">SetTriggerMethodTriggerPulseOptions</a> | <a href="#settriggermethodcontinuouslongpressoptions">SetTriggerMethodContinuousLongPressOptions</a></code>


#### OnScanResultListener

Callback to receive scan results broadcasted by the scanner

<code>(scan: { data: string; source_bytes: string; }): void</code>


#### OnScanStartListener

Callback to receive scan start event broadcasted by the scanner

<code>(): void</code>


#### OnScanStopListener

Callback to receive scan stop event broadcasted by the scanner

<code>(): void</code>


### Enums


#### ScannerModel

| Members                 | Value                            |
| ----------------------- | -------------------------------- |
| **`NONE`**              | <code>"NONE"</code>              |
| **`SUPER_N1365_Y1825`** | <code>"SUPER_N1365_Y1825"</code> |
| **`NLS_2096`**          | <code>"NLS_2096"</code>          |
| **`ZEBRA_4710`**        | <code>"ZEBRA_4710"</code>        |
| **`HONEYWELL_3601`**    | <code>"HONEYWELL_3601"</code>    |
| **`HONEYWELL_6603`**    | <code>"HONEYWELL_6603"</code>    |
| **`ZEBRA_4750`**        | <code>"ZEBRA_4750"</code>        |
| **`ZEBRA_1350`**        | <code>"ZEBRA_1350"</code>        |
| **`HONEYWELL_6703`**    | <code>"HONEYWELL_6703"</code>    |
| **`HONEYWELL_3603`**    | <code>"HONEYWELL_3603"</code>    |
| **`NLS_CM47`**          | <code>"NLS_CM47"</code>          |
| **`NLS_3108`**          | <code>"NLS_3108"</code>          |
| **`ZEBRA_965`**         | <code>"ZEBRA_965"</code>         |
| **`SM_SS_1100`**        | <code>"SM_SS_1100"</code>        |
| **`NLS_CM30`**          | <code>"NLS_CM30"</code>          |
| **`HONEYWELL_4603`**    | <code>"HONEYWELL_4603"</code>    |
| **`ZEBRA_4770`**        | <code>"ZEBRA_4770"</code>        |
| **`NLS_2596`**          | <code>"NLS_2596"</code>          |
| **`SM_SS_1103`**        | <code>"SM_SS_1103"</code>        |
| **`SM_SS_1101`**        | <code>"SM_SS_1101"</code>        |
| **`HONEYWELL_5703`**    | <code>"HONEYWELL_5703"</code>    |
| **`UNKNOWN`**           | <code>"UNKNOWN"</code>           |


#### OutputMode

| Members                     | Value                                   | Description                             |
| --------------------------- | --------------------------------------- | --------------------------------------- |
| **`DirectFill`**            | <code>"direct-fill"</code>              | Fill in EditText directly               |
| **`DirectFillWithReplace`** | <code>"direct-fill-with-replace"</code> | Fill and overwrite in EditText directly |
| **`Keystroke`**             | <code>"keystroke"</code>                | Virtual Keyboard output                 |
| **`Disabled`**              | <code>"disabled"</code>                 | No direct output                        |


#### ScanMode

| Members          | Value                     | Description                                                                                |
| ---------------- | ------------------------- | ------------------------------------------------------------------------------------------ |
| **`Trigger`**    | <code>"trigger"</code>    | Trigger Mode: Short press to scan, and release to stop scanning                            |
| **`Continuous`** | <code>"continuous"</code> | Continuous Mode: Short press to start scanning, and short press to stop scanning           |
| **`Pulse`**      | <code>"pulse"</code>      | Pulse Mode: Short press to start scanning until timeout                                    |
| **`LongPress`**  | <code>"long-press"</code> | Long Press Mode: Long press to scan continuously, release to stop Hardware support limited |


#### ScanResultCodeIDEnum

| Members        | Value                    | Description              |
| -------------- | ------------------------ | ------------------------ |
| **`None`**     | <code>"none"</code>      |                          |
| **`SunmiId`**  | <code>"sunmi-id"</code>  |                          |
| **`AimId`**    | <code>"aim-id"</code>    | Hardware support limited |
| **`SymbolId`** | <code>"symbol-id"</code> | Hardware support limited |

</docgen-api>
