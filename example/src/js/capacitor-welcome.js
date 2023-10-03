import {SplashScreen} from '@capacitor/splash-screen';
import {SunmiBarcodeScanner} from "../../../src";

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
