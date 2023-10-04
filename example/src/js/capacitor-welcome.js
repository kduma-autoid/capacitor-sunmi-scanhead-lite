import {SplashScreen} from '@capacitor/splash-screen';
import {OutputMode, ScanMode, SunmiBarcodeScanner} from "../../../src";

window.customElements.define(
  'capacitor-welcome',
  class extends HTMLElement {
    constructor() {
      super();

      SplashScreen.hide();

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
        <h1>@kduma-autoid/capacitor-sunmi-barcode-scanner</h1>
      </capacitor-welcome-titlebar>
      <main>
        <p>
          <button class="button" id="scan">scan()</button>
          <button class="button" id="stop">stop()</button>
          <button class="button" id="getScannerModel">getScannerModel()</button>
          <button class="button" id="clearConfig">clearConfig()</button>
          <hr>
          <button class="button" id="setTrigger1">setTrigger(true)</button>
          <button class="button" id="setTrigger0">setTrigger(false)</button>
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
          <button class="button" id="setReturnCodeType1">setReturnCodeType(true)</button>
          <button class="button" id="setReturnCodeType0">setReturnCodeType(false)</button>
          <hr>
          <button class="button" id="setBroadcast1">setBroadcast(true)</button>
          <button class="button" id="setBroadcast0">setBroadcast(false)</button>
          <button class="button" id="setBroadcastConfiguration">setBroadcastConfiguration()</button>
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
        output.innerHTML = "<b>" + key + ":</b><br><pre>" + content + "</pre><hr>" + output.innerHTML;
      }

      SunmiBarcodeScanner.addListener('onScanResult', (scan) => {
        printToOutput("onScanResult", JSON.stringify(scan, null, 3));
      });

      SunmiBarcodeScanner.addListener('onScanStart', () => {
        printToOutput("onScanStart", JSON.stringify({}, null, 3));
      });

      SunmiBarcodeScanner.addListener('onScanStop', () => {
        printToOutput("onScanStop", JSON.stringify({}, null, 3));
      });

      self.shadowRoot.querySelector('#scan').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.scan();
      });

      self.shadowRoot.querySelector('#stop').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.stop();
      });

      self.shadowRoot.querySelector('#getScannerModel').addEventListener('click', async function (e) {
        let response = await SunmiBarcodeScanner.getScannerModel();
        printToOutput("getScannerModel()", JSON.stringify(response, null, 3));
      });

      self.shadowRoot.querySelector('#setTrigger1').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setTrigger({enabled: true});
      });

      self.shadowRoot.querySelector('#setTrigger0').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setTrigger({enabled: false});
      });

      self.shadowRoot.querySelector('#setReturnCodeType1').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setReturnCodeType({enabled: true});
      });

      self.shadowRoot.querySelector('#setReturnCodeType0').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setReturnCodeType({enabled: false});
      });

      self.shadowRoot.querySelector('#setBroadcast1').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setBroadcast({enabled: true});
      });

      self.shadowRoot.querySelector('#setBroadcast0').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setBroadcast({enabled: false});
      });

      self.shadowRoot.querySelector('#setOutputModeDisabled').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setOutputMode({mode: OutputMode.DISABLED});
      });

      self.shadowRoot.querySelector('#setOutputModeKeystroke').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setOutputMode({mode: OutputMode.KEYSTROKE});
      });

      self.shadowRoot.querySelector('#setOutputModeDirectfill').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setOutputMode({mode: OutputMode.DIRECTFILL});
      });

      self.shadowRoot.querySelector('#setScanModeTrigger').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setScanMode({mode: ScanMode.TRIGGER});
      });

      self.shadowRoot.querySelector('#setScanModePulse').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setScanMode({mode: ScanMode.PULSE});
      });

      self.shadowRoot.querySelector('#setScanModeContinuous').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setScanMode({mode: ScanMode.CONTINUOUS});
      });

      self.shadowRoot.querySelector('#setScanModeLongpress').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setScanMode({mode: ScanMode.LONGPRESS});
      });

      self.shadowRoot.querySelector('#setBroadcastConfiguration').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.setBroadcastConfiguration();
      });

      self.shadowRoot.querySelector('#clearConfig').addEventListener('click', async function (e) {
        await SunmiBarcodeScanner.clearConfig();
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
