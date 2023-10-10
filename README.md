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
getScannerModel() => Promise<{ id: number; name: ScannerModelName; }>
```

Get scanner model

**Returns:** <code>Promise&lt;{ id: number; name: string; }&gt;</code>

--------------------


### clearConfig()

```typescript
clearConfig() => Promise<{ cleared: boolean; }>
```

Clear scanner configuration (reset to default)

**Returns:** <code>Promise&lt;{ cleared: boolean; }&gt;</code>

--------------------


### setTrigger(...)

```typescript
setTrigger(options: { enabled: boolean; }) => Promise<void>
```

Enable or disable trigger button

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

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
setOutputType(options: { mode: OutputMode.Disabled; } | { mode: OutputMode.Keystroke; interval?: number; tab?: boolean; enter?: boolean; space?: boolean; } | { mode: OutputMode.DirectFill | OutputMode.DirectFillWithReplace; tab?: boolean; enter?: boolean; space?: boolean; asEvent?: boolean; }) => Promise<void>
```

Set output mode

| Param         | Type                                                                                                                                                                                                                                                                                                                                                                                                   |
| ------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| **`options`** | <code>{ mode: <a href="#outputmode">OutputMode.Disabled</a>; } \| { mode: <a href="#outputmode">OutputMode.Keystroke</a>; interval?: number; tab?: boolean; enter?: boolean; space?: boolean; } \| { mode: <a href="#outputmode">OutputMode.DirectFill</a> \| <a href="#outputmode">OutputMode.DirectFillWithReplace</a>; tab?: boolean; enter?: boolean; space?: boolean; asEvent?: boolean; }</code> |

--------------------


### setTriggerMethod(...)

```typescript
setTriggerMethod(options?: { mode: ScanMode.Trigger | ScanMode.Pulse; timeout?: number | undefined; } | { mode: ScanMode.Continuous | ScanMode.LongPress; sleep?: number | undefined; timeout?: number | undefined; } | undefined) => Promise<void>
```

Set scan mode

| Param         | Type                                                                                                                                                                                                                                                                   |
| ------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ mode: <a href="#scanmode">ScanMode.Trigger</a> \| <a href="#scanmode">ScanMode.Pulse</a>; timeout?: number; } \| { mode: <a href="#scanmode">ScanMode.Continuous</a> \| <a href="#scanmode">ScanMode.LongPress</a>; sleep?: number; timeout?: number; }</code> |

--------------------


### setScanResultCodeID(...)

```typescript
setScanResultCodeID(options?: { type: ScanResultCodeIDEnum; } | undefined) => Promise<void>
```

Selects variant of code type returned with scan result

if empty, defaults to <a href="#scanresultcodeidenum">`ScanResultCodeIDEnum.None`</a>

| Param         | Type                                                                             |
| ------------- | -------------------------------------------------------------------------------- |
| **`options`** | <code>{ type: <a href="#scanresultcodeidenum">ScanResultCodeIDEnum</a>; }</code> |

--------------------


### setAdvancedFormatEnabled(...)

```typescript
setAdvancedFormatEnabled(options?: { enabled: boolean; } | undefined) => Promise<void>
```

Enable or disable advanced formatting options provided in configuration

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setBeep(...)

```typescript
setBeep(options?: { enabled: boolean; } | undefined) => Promise<void>
```

Enable or disable sound prompts on scan

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setVibrate(...)

```typescript
setVibrate(options?: { enabled: boolean; } | undefined) => Promise<void>
```

Enable or disable vibration prompts on scan

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setOutputBroadcastEnabled(...)

```typescript
setOutputBroadcastEnabled(options?: { enabled: boolean; } | undefined) => Promise<void>
```

Enable or disable scan result broadcast

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setBroadcastConfiguration(...)

```typescript
setBroadcastConfiguration(options?: { scanned_intent?: string | undefined; start_intent?: string | undefined; end_intent?: string | undefined; intent_data_key?: string | undefined; intent_byte_key?: string | undefined; } | undefined) => Promise<void>
```

Set broadcast configuration

| Param         | Type                                                                                                                                      |
| ------------- | ----------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ scanned_intent?: string; start_intent?: string; end_intent?: string; intent_data_key?: string; intent_byte_key?: string; }</code> |

--------------------


### addListener('onScanResult', ...)

```typescript
addListener(eventName: 'onScanResult', listenerFunc: (scan: { data: string; source_bytes: string; }) => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner result events.

| Param              | Type                                                                    |
| ------------------ | ----------------------------------------------------------------------- |
| **`eventName`**    | <code>'onScanResult'</code>                                             |
| **`listenerFunc`** | <code>(scan: { data: string; source_bytes: string; }) =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onScanStart', ...)

```typescript
addListener(eventName: 'onScanStart', listenerFunc: () => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner start events.

| Param              | Type                       |
| ------------------ | -------------------------- |
| **`eventName`**    | <code>'onScanStart'</code> |
| **`listenerFunc`** | <code>() =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### addListener('onScanStop', ...)

```typescript
addListener(eventName: 'onScanStop', listenerFunc: () => void) => Promise<PluginListenerHandle> & PluginListenerHandle
```

Listens for barcode scanner stop events.

| Param              | Type                       |
| ------------------ | -------------------------- |
| **`eventName`**    | <code>'onScanStop'</code>  |
| **`listenerFunc`** | <code>() =&gt; void</code> |

**Returns:** <code>Promise&lt;<a href="#pluginlistenerhandle">PluginListenerHandle</a>&gt; & <a href="#pluginlistenerhandle">PluginListenerHandle</a></code>

--------------------


### removeAllListeners()

```typescript
removeAllListeners() => Promise<void>
```

Removes all listeners

--------------------


### Interfaces


#### PluginListenerHandle

| Prop         | Type                                      |
| ------------ | ----------------------------------------- |
| **`remove`** | <code>() =&gt; Promise&lt;void&gt;</code> |


### Type Aliases


#### ScannerModelName

<code>string | "NONE" | "SUPER_N1365_Y1825" | "NLS_2096" | "ZEBRA_4710" | "HONEYWELL_3601" | "HONEYWELL_6603" | "ZEBRA_4750" | "ZEBRA_1350" | "HONEYWELL_6703" | "HONEYWELL_3603" | "NLS_CM47" | "NLS_3108" | "ZEBRA_965" | "SM_SS_1100" | "NLS_CM30" | "HONEYWELL_4603" | "ZEBRA_4770" | "NLS_2596" | "SM_SS_1103" | "SM_SS_1101" | "HONEYWELL_5703" | "UNKNOWN"</code>


### Enums


#### OutputMode

| Members                     | Value                                   |
| --------------------------- | --------------------------------------- |
| **`DirectFill`**            | <code>"direct-fill"</code>              |
| **`DirectFillWithReplace`** | <code>"direct-fill-with-replace"</code> |
| **`Keystroke`**             | <code>"keystroke"</code>                |
| **`Disabled`**              | <code>"disabled"</code>                 |


#### ScanMode

| Members          | Value                     |
| ---------------- | ------------------------- |
| **`Trigger`**    | <code>"trigger"</code>    |
| **`Continuous`** | <code>"continuous"</code> |
| **`Pulse`**      | <code>"pulse"</code>      |
| **`LongPress`**  | <code>"long-press"</code> |


#### ScanResultCodeIDEnum

| Members        | Value                    |
| -------------- | ------------------------ |
| **`None`**     | <code>"none"</code>      |
| **`SunmiId`**  | <code>"sunmi-id"</code>  |
| **`AimId`**    | <code>"aim-id"</code>    |
| **`SymbolId`** | <code>"symbol-id"</code> |

</docgen-api>
