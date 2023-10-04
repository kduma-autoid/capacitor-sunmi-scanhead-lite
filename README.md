# @kduma-autoid/capacitor-sunmi-barcode-scanner

Sunmi Barcode Scanner bindings for Capacitor

## Install

```bash
npm install @kduma-autoid/capacitor-sunmi-barcode-scanner
npx cap sync
```
## Configuration

You can disable auto binding of the service by setting `bindOnLoad` to `false` in the plugin configuration in `capacitor.config.ts`.

```typescript
/// <reference types="@kduma-autoid/capacitor-sunmi-barcode-scanner" />
import { CapacitorConfig } from '@capacitor/cli';

const config: CapacitorConfig = {
  appId: "com.company.app",
  ...
  plugins: {
    SunmiBarcodeScanner: {
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
* [`setOutputMode(...)`](#setoutputmode)
* [`setScanMode(...)`](#setscanmode)
* [`setReturnCodeType(...)`](#setreturncodetype)
* [`setBroadcast(...)`](#setbroadcast)
* [`setBroadcastConfiguration(...)`](#setbroadcastconfiguration)
* [`addListener('onScanResult', ...)`](#addlisteneronscanresult)
* [`addListener('onScanStart', ...)`](#addlisteneronscanstart)
* [`addListener('onScanStop', ...)`](#addlisteneronscanstop)
* [`removeAllListeners()`](#removealllisteners)
* [Interfaces](#interfaces)
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
getScannerModel() => Promise<{ model: number; }>
```

Get scanner model ID

**Returns:** <code>Promise&lt;{ model: number; }&gt;</code>

--------------------


### clearConfig()

```typescript
clearConfig() => Promise<void>
```

Clear scanner configuration (reset to default)

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


### setOutputMode(...)

```typescript
setOutputMode(options: { mode: OutputMode.DISABLED; } | { mode: OutputMode.KEYSTROKE; interval?: number; tab?: boolean; enter?: boolean; } | { mode: OutputMode.DIRECTFILL; overwrite?: boolean; tab?: boolean; enter?: boolean; asEvent?: boolean; }) => Promise<void>
```

Set output mode

| Param         | Type                                                                                                                                                                                                                                                                                                                        |
| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ mode: <a href="#outputmode">OutputMode.DISABLED</a>; } \| { mode: <a href="#outputmode">OutputMode.KEYSTROKE</a>; interval?: number; tab?: boolean; enter?: boolean; } \| { mode: <a href="#outputmode">OutputMode.DIRECTFILL</a>; overwrite?: boolean; tab?: boolean; enter?: boolean; asEvent?: boolean; }</code> |

--------------------


### setScanMode(...)

```typescript
setScanMode(options: { mode: ScanMode.TRIGGER | ScanMode.PULSE; timeout?: number; } | { mode: ScanMode.CONTINUOUS | ScanMode.LONGPRESS; sleep?: number; timeout?: number; }) => Promise<void>
```

Set scan mode

| Param         | Type                                                                                                                                                                                                                                                                   |
| ------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ mode: <a href="#scanmode">ScanMode.TRIGGER</a> \| <a href="#scanmode">ScanMode.PULSE</a>; timeout?: number; } \| { mode: <a href="#scanmode">ScanMode.CONTINUOUS</a> \| <a href="#scanmode">ScanMode.LONGPRESS</a>; sleep?: number; timeout?: number; }</code> |

--------------------


### setReturnCodeType(...)

```typescript
setReturnCodeType(options: { enabled: boolean; }) => Promise<void>
```

Enable or disable returning of code type with scan result

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setBroadcast(...)

```typescript
setBroadcast(options: { enabled: boolean; }) => Promise<void>
```

Enable or disable scan result broadcast

| Param         | Type                               |
| ------------- | ---------------------------------- |
| **`options`** | <code>{ enabled: boolean; }</code> |

--------------------


### setBroadcastConfiguration(...)

```typescript
setBroadcastConfiguration(options?: { scanned_intent?: string | null | undefined; start_intent?: string | null | undefined; end_intent?: string | null | undefined; intent_data_key?: string | null | undefined; intent_byte_key?: string | null | undefined; } | undefined) => Promise<void>
```

Set broadcast configuration

| Param         | Type                                                                                                                                                                              |
| ------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`options`** | <code>{ scanned_intent?: string \| null; start_intent?: string \| null; end_intent?: string \| null; intent_data_key?: string \| null; intent_byte_key?: string \| null; }</code> |

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


### Enums


#### OutputMode

| Members          | Value                     |
| ---------------- | ------------------------- |
| **`KEYSTROKE`**  | <code>"keystroke"</code>  |
| **`DIRECTFILL`** | <code>"directFill"</code> |
| **`DISABLED`**   | <code>"disabled"</code>   |


#### ScanMode

| Members          | Value                     |
| ---------------- | ------------------------- |
| **`TRIGGER`**    | <code>"trigger"</code>    |
| **`CONTINUOUS`** | <code>"continuous"</code> |
| **`PULSE`**      | <code>"pulse"</code>      |
| **`LONGPRESS`**  | <code>"longPress"</code>  |

</docgen-api>
