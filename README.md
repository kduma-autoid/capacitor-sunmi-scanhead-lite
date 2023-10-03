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
getScannerModel() => Promise<{ model: ScannerModel | number; }>
```

Get scanner model

100 → NONE
101 → P2Lite/V2Pro/P2Pro(em1365/BSM1825)
102 → L2-newland(EM2096)
103 → L2-zabra(SE4710)
104 → L2-HoneyWell(N3601)
105 → L2-HoneyWell(N6603)
106 → L2-Zabra(SE4750)
107 → L2-Zabra(EM1350)

**Returns:** <code>Promise&lt;{ model: number; }&gt;</code>

--------------------


### Enums


#### ScannerModel

| Members       | Value            |
| ------------- | ---------------- |
| **`UNKNOWN`** | <code>0</code>   |
| **`NONE`**    | <code>100</code> |
| **`BSM1825`** | <code>101</code> |
| **`EM2096`**  | <code>102</code> |
| **`SE4710`**  | <code>103</code> |
| **`N3601`**   | <code>104</code> |
| **`N6603`**   | <code>105</code> |
| **`SE4750`**  | <code>106</code> |
| **`EM1350`**  | <code>107</code> |

</docgen-api>
