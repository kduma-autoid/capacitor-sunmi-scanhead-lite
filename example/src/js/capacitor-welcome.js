import {SplashScreen} from '@capacitor/splash-screen';
import {OutputMode, ScanMode, ScanResultCodeIDEnum, SunmiScanHead} from "../../../src";
import {WebViewWatchDog} from "@kduma-autoid/capacitor-webview-watchdog";

window.customElements.define(
  'capacitor-welcome',
  class extends HTMLElement {
    constructor() {
      super();

      SplashScreen.hide();
      WebViewWatchDog.ping();

      const root = this.attachShadow({ mode: 'open' });

      root.innerHTML = `
    <style>
      :host {
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        display: block;
        width: 100%;
        height: 100%;
      }
      h1, h2, h3, h4, h5 {
        text-transform: uppercase;
      }
      .button {
        display: inline-block;
        padding: 10px;
        background-color: #73B5F6;
        color: #fff;
        font-size: 0.9em;
        border: 0;
        border-radius: 3px;
        text-decoration: none;
        cursor: pointer;
      }
      main {
        padding: 15px;
      }
      main hr { height: 1px; background-color: #eee; border: 0; }
      main h1 {
        font-size: 1.4em;
        text-transform: uppercase;
        letter-spacing: 1px;
      }
      main h2 {
        font-size: 1.1em;
      }
      main h3 {
        font-size: 0.9em;
      }
      main p {
        color: #333;
      }
      main pre {
        white-space: pre-line;
      }
    </style>
    <div>
      <capacitor-welcome-titlebar>
        <h1>@kduma-autoid/capacitor-sunmi-scanhead</h1>
      </capacitor-welcome-titlebar>
      <main>
        <p>
          <button class="button" id="scan">scan()</button>
          <button class="button" id="stop">stop()</button>
          <button class="button" id="getScannerModel">getScannerModel()</button>
          <button class="button" id="clearConfig">clearConfig()</button>
          <hr>
          <button class="button" id="beep">beep()</button>
          <button class="button" id="vibrate">vibrate()</button>
          <hr>
          <button class="button" id="setTrigger1">setTrigger(true)</button>
          <button class="button" id="setTrigger0">setTrigger(false)</button>
          <hr>
          <button class="button" id="createWriteContext">createWriteContext()</button>
          <button class="button" id="commitWriteContext">commitWriteContext()</button>
          <button class="button" id="discardWriteContext">discardWriteContext()</button>
          <hr>
          <button class="button" id="setOutputModeDisabled">setOutputMode(DISABLED)</button>
          <button class="button" id="setOutputModeKeystroke">setOutputMode(KEYSTROKE)</button>
          <button class="button" id="setOutputModeDirectfill">setOutputMode(DIRECTFILL)</button>
          <hr>
          <button class="button" id="setScanModeTrigger">setScanMode(TRIGGER)</button>
          <button class="button" id="setScanModePulse">setScanMode(PULSE)</button>
          <button class="button" id="setScanModeContinuous">setScanMode(CONTINUOUS)</button>
          <button class="button" id="setScanModeLongpress">setScanMode(LONGPRESS)</button>
          <hr>
          <button class="button" id="setScanResultCodeIDNone">setScanResultCodeID(None)</button>
          <button class="button" id="setScanResultCodeIDSunmiId">setScanResultCodeID(SunmiId)</button>
          <button class="button" id="setScanResultCodeIDAimId">setScanResultCodeID(AimId)</button>
          <button class="button" id="setScanResultCodeIDSymbolId">setScanResultCodeID(SymbolId)</button>
          <hr>
          <button class="button" id="setBeep1">setBeep(true)</button>
          <button class="button" id="setBeep0">setBeep(false)</button>
          <button class="button" id="setVibrate1">setVibrate(true)</button>
          <button class="button" id="setVibrate0">setVibrate(false)</button>
          <hr>
          <button class="button" id="setAdvancedFormatEnabled1">setAdvancedFormatEnabled(true)</button>
          <button class="button" id="setAdvancedFormatEnabled0">setAdvancedFormatEnabled(false)</button>
          <hr>
          <button class="button" id="setOutputBroadcastEnabled1">setOutputBroadcastEnabled(true)</button>
          <button class="button" id="setOutputBroadcastEnabled0">setOutputBroadcastEnabled(false)</button>
          <button class="button" id="setBroadcastConfiguration">setBroadcastConfiguration()</button>
        </p> 
        <hr>
        <h2>Complex Examples</h2>
        <p>
          <button class="button" id="example_normal">Normal Picking</button>
          <button class="button" id="example_fastbatch">Fast batch scan</button>
          <button class="button" id="example_fastbatch_alt">Fast batch scan (ALT)</button>
        </p>        
        
        <h2>Events</h2>
        <p id="output"></p>
      </main>
    </div>
    `;
    }

    connectedCallback() {
      const self = this;

      function printToOutput(key, content) {
        const output = self.shadowRoot.querySelector('#output');
        output.innerHTML = "<b>" + key + ":</b><br><pre>" + JSON.stringify(content, null, 3) + "</pre><hr>" + output.innerHTML;
      }

      SunmiScanHead.addListener('onScanResult', (scan) => {
        printToOutput("onScanResult", scan);
      });

      SunmiScanHead.addListener('onScanStart', () => {
        printToOutput("onScanStart", {});
      });

      SunmiScanHead.addListener('onScanStop', () => {
        printToOutput("onScanStop", {});
      });

      self.shadowRoot.querySelector('#scan').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.scan();
        } catch (e) {
          printToOutput("scan() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#stop').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.stop();
        } catch (e) {
          printToOutput("stop() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#getScannerModel').addEventListener('click', async function (e) {
        try {
          printToOutput("getScannerModel()", await SunmiScanHead.getScannerModel());
        } catch (e) {
          printToOutput("getScannerModel() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTrigger1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTrigger({enabled: true});
        } catch (e) {
          printToOutput("setTrigger() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTrigger0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTrigger({enabled: false});
        } catch (e) {
          printToOutput("setTrigger() - ERROR", { message: e.message, code: e.code });
        }
      });



      self.shadowRoot.querySelector('#createWriteContext').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext();
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#commitWriteContext').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.commitWriteContext();
        } catch (e) {
          printToOutput("commitWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#discardWriteContext').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.discardWriteContext();
        } catch (e) {
          printToOutput("discardWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanResultCodeIDNone').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.None});
        } catch (e) {
          printToOutput("setScanResultCodeID(None) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanResultCodeIDSunmiId').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.SunmiId});
        } catch (e) {
          printToOutput("setScanResultCodeID(SunmiId) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanResultCodeIDAimId').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.AimId});
        } catch (e) {
          printToOutput("setScanResultCodeID(AimId) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanResultCodeIDSymbolId').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.SymbolId});
        } catch (e) {
          printToOutput("setScanResultCodeID(SymbolId) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputBroadcastEnabled1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputBroadcastEnabled({enabled: true});
        } catch (e) {
          printToOutput("setOutputBroadcastEnabled(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputBroadcastEnabled0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputBroadcastEnabled({enabled: false});
        } catch (e) {
          printToOutput("setOutputBroadcastEnabled(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setAdvancedFormatEnabled1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setAdvancedFormatEnabled({enabled: true});
        } catch (e) {
          printToOutput("setAdvancedFormatEnabled(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setAdvancedFormatEnabled0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setAdvancedFormatEnabled({enabled: false});
        } catch (e) {
          printToOutput("setAdvancedFormatEnabled(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setBeep1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setBeep({enabled: true});
        } catch (e) {
          printToOutput("setBeep(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setBeep0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setBeep({enabled: false});
        } catch (e) {
          printToOutput("setBeep(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setVibrate1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setVibrate({enabled: true});
        } catch (e) {
          printToOutput("setVibrate(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setVibrate0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setVibrate({enabled: false});
        } catch (e) {
          printToOutput("setVibrate(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputModeDisabled').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.DISABLED});
        } catch (e) {
          printToOutput("setOutputMode(DISABLED) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputModeKeystroke').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.KEYSTROKE});
        } catch (e) {
          printToOutput("setOutputMode(KEYSTROKE) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputModeDirectfill').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.DIRECTFILL});
        } catch (e) {
          printToOutput("setOutputMode(DIRECTFILL) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanModeTrigger').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.TRIGGER});
        } catch (e) {
          printToOutput("setScanMode(TRIGGER) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanModePulse').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.PULSE});
        } catch (e) {
          printToOutput("setScanMode(PULSE) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanModeContinuous').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.CONTINUOUS});
        } catch (e) {
          printToOutput("setScanMode(CONTINUOUS) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setScanModeLongpress').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.LONGPRESS});
        } catch (e) {
          printToOutput("setScanMode(LONGPRESS) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setBroadcastConfiguration').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setBroadcastConfiguration();
        } catch (e) {
          printToOutput("setBroadcastConfiguration() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#clearConfig').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.clearConfig();
        } catch (e) {
          printToOutput("clearConfig() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#beep').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.beep();
        } catch (e) {
          printToOutput("beep() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#vibrate').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.vibrate();
        } catch (e) {
          printToOutput("vibrate() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#example_normal').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext();
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBroadcastConfiguration({start_intent: "", end_intent: ""});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: \"\", end_intent: \"\") - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.DISABLED});
        } catch (e) {
          printToOutput("setOutputMode(DISABLED) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputBroadcastEnabled({enabled: true});
        } catch (e) {
          printToOutput("setBroadcast(true) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.None});
        } catch (e) {
          printToOutput("setScanResultCodeID(None) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setAdvancedFormatEnabled({enabled: false});
        } catch (e) {
          printToOutput("setAdvancedFormatEnabled(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBeep({enabled: true});
        } catch (e) {
          printToOutput("setBeep(true) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setVibrate({enabled: true});
        } catch (e) {
          printToOutput("setVibrate(true) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.TRIGGER});
        } catch (e) {
          printToOutput("setScanMode(TRIGGER) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.commitWriteContext();
        } catch (e) {
          printToOutput("commitWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#example_fastbatch').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext();
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBroadcastConfiguration({start_intent: "", end_intent: ""});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: \"\", end_intent: \"\") - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.DISABLED});
        } catch (e) {
          printToOutput("setOutputMode(DISABLED) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputBroadcastEnabled({enabled: true});
        } catch (e) {
          printToOutput("setBroadcast(true) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.None});
        } catch (e) {
          printToOutput("setScanResultCodeID(None) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setAdvancedFormatEnabled({enabled: false});
        } catch (e) {
          printToOutput("setAdvancedFormatEnabled(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBeep({enabled: false});
        } catch (e) {
          printToOutput("setBeep(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setVibrate({enabled: false});
        } catch (e) {
          printToOutput("setVibrate(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.LONGPRESS, sleep: 50});
        } catch (e) {
          printToOutput("setScanMode(LONGPRESS, sleep: 50) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.commitWriteContext();
        } catch (e) {
          printToOutput("commitWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#example_fastbatch_alt').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext();
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBroadcastConfiguration({start_intent: "", end_intent: ""});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: \"\", end_intent: \"\") - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputMode({mode: OutputMode.DISABLED});
        } catch (e) {
          printToOutput("setOutputMode(DISABLED) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputBroadcastEnabled({enabled: true});
        } catch (e) {
          printToOutput("setBroadcast(true) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanResultCodeID({type: ScanResultCodeIDEnum.None});
        } catch (e) {
          printToOutput("setScanResultCodeID(None) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setAdvancedFormatEnabled({enabled: false});
        } catch (e) {
          printToOutput("setAdvancedFormatEnabled(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBeep({enabled: false});
        } catch (e) {
          printToOutput("setBeep(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setVibrate({enabled: false});
        } catch (e) {
          printToOutput("setVibrate(false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setScanMode({mode: ScanMode.CONTINUOUS, sleep: 50});
        } catch (e) {
          printToOutput("setScanMode(CONTINUOUS, sleep: 50) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.commitWriteContext();
        } catch (e) {
          printToOutput("commitWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });
    }
  }
);

window.customElements.define(
  'capacitor-welcome-titlebar',
  class extends HTMLElement {
    constructor() {
      super();
      const root = this.attachShadow({ mode: 'open' });
      root.innerHTML = `
    <style>
      :host {
        position: relative;
        display: block;
        padding: 15px 15px 15px 15px;
        text-align: center;
        background-color: #73B5F6;
      }
      ::slotted(h1) {
        margin: 0;
        font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
        font-size: 0.9em;
        font-weight: 600;
        color: #fff;
      }
    </style>
    <slot></slot>
    `;
    }
  }
);
