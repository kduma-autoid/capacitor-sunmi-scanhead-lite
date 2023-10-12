import {SplashScreen} from '@capacitor/splash-screen';
import {
  CenterDecodingSettingEnum,
  OutputEncodingCodeEnum,
  OutputMode,
  ScanMode,
  ScanResultCodeIDEnum, SpecificSceneEnum,
  SunmiScanHead, WriteContextType
} from "../../../src";
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
          <button class="button" id="createWriteContextService">createWriteContext(Service)</button>
          <button class="button" id="createWriteContextDecoders">createWriteContext(Decoders)</button>
          <button class="button" id="commitWriteContext">commitWriteContext()</button>
          <button class="button" id="discardWriteContext">discardWriteContext()</button>
          <hr>
          <button class="button" id="setOutputTypeDisabled">setOutputType(Disabled)</button>
          <button class="button" id="setOutputTypeKeystroke">setOutputType(Keystroke)</button>
          <button class="button" id="setOutputTypeDirectFill">setOutputType(DirectFill)</button>
          <button class="button" id="setOutputTypeDirectFillWithReplace">setOutputType(DirectFillWithReplace)</button>
          <hr>
          <button class="button" id="setTriggerMethodTrigger">setTriggerMethod(Trigger)</button>
          <button class="button" id="setTriggerMethodPulse">setTriggerMethod(Pulse)</button>
          <button class="button" id="setTriggerMethodContinuous">setTriggerMethod(Continuous)</button>
          <button class="button" id="setTriggerMethodLongPress">setTriggerMethod(LongPress)</button>
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
          <button class="button" id="setBroadcastConfigurationNoStartEnd">setBroadcastConfiguration(start_intent: false, end_intent: false)</button>
          <hr>
          <button class="button" id="setOutputEncodingCodeUTF8">setOutputEncodingCode(UTF8)</button>
          <button class="button" id="setOutputEncodingCodeAuto">setOutputEncodingCode(Auto)</button>
          <hr>
          <button class="button" id="setVirtualFloatingScanButton1">setVirtualFloatingScanButton(true)</button>
          <button class="button" id="setVirtualFloatingScanButton0">setVirtualFloatingScanButton(false)</button>
          <hr>
          <button class="button" id="setCenterFlagScanDisabled">setCenterFlagScan(Disabled)</button>
          <button class="button" id="setCenterFlagScanCenterOnly">setCenterFlagScan(CenterOnly)</button>
          <button class="button" id="setCenterFlagScanCenterFirst">setCenterFlagScan(CenterFirst)</button>
          <hr>
          <button class="button" id="setFlash1">setFlash(true)</button>
          <button class="button" id="setFlash0">setFlash(false)</button>
          <hr>
          <button class="button" id="setSceneDefault">setScene(Default)</button>
          <button class="button" id="setSceneMobileScreenScene">setScene(MobileScreenScene)</button>
          <hr>
          <button class="button" id="setRemoveGroupSeparator1">setRemoveGroupSeparator(true)</button>
          <button class="button" id="setRemoveGroupSeparator0">setRemoveGroupSeparator(false)</button>
          <hr>
          <button class="button" id="setPrefix">setPrefix()</button>
          <button class="button" id="setPrefixPrefix">setPrefix(prefix-)</button>
          <hr>
          <button class="button" id="setPrefixCharactersRemoved">setPrefixCharactersRemoved()</button>
          <button class="button" id="setPrefixCharactersRemoved5">setPrefixCharactersRemoved(5)</button>
          <hr>
          <button class="button" id="setSuffix">setSuffix()</button>
          <button class="button" id="setSuffixSuffix">setSuffix(-suffix)</button>
          <hr>
          <button class="button" id="setSuffixCharactersRemoved">setSuffixCharactersRemoved()</button>
          <button class="button" id="setSuffixCharactersRemoved5">setSuffixCharactersRemoved(5)</button>
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
          await SunmiScanHead.createWriteContext({
            // type: [
            //     WriteContextType.Decoders,
            //     WriteContextType.Service
            // ]
          });
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#createWriteContextService').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext({
            type: WriteContextType.Service
          });
        } catch (e) {
          printToOutput("createWriteContext(Service) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#createWriteContextDecoders').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext({
            type: WriteContextType.Decoders
          });
        } catch (e) {
          printToOutput("createWriteContext(Decoders) - ERROR", { message: e.message, code: e.code });
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

      self.shadowRoot.querySelector('#setOutputTypeDisabled').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.Disabled});
        } catch (e) {
          printToOutput("setOutputType(Disabled) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputTypeKeystroke').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.Keystroke});
        } catch (e) {
          printToOutput("setOutputType(Keystroke) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputTypeDirectFill').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.DirectFill});
        } catch (e) {
          printToOutput("setOutputType(DirectFill) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputTypeDirectFillWithReplace').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.DirectFillWithReplace});
        } catch (e) {
          printToOutput("setOutputType(DirectFillWithReplace) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTriggerMethodTrigger').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.Trigger});
        } catch (e) {
          printToOutput("setTriggerMethod(Trigger) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTriggerMethodPulse').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.Pulse});
        } catch (e) {
          printToOutput("setTriggerMethod(Pulse) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTriggerMethodContinuous').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.Continuous});
        } catch (e) {
          printToOutput("setTriggerMethod(Continuous) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setTriggerMethodLongPress').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.LongPress});
        } catch (e) {
          printToOutput("setTriggerMethod(LongPress) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setBroadcastConfiguration').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setBroadcastConfiguration();
        } catch (e) {
          printToOutput("setBroadcastConfiguration() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setBroadcastConfigurationNoStartEnd').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setBroadcastConfiguration({start_intent: false, end_intent: false});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: false, end_intent: false) - ERROR", { message: e.message, code: e.code });
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

      self.shadowRoot.querySelector('#setOutputEncodingCodeUTF8').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputEncodingCode({encoding: OutputEncodingCodeEnum.UTF8});
        } catch (e) {
          printToOutput("setOutputEncodingCode(UTF8) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setOutputEncodingCodeAuto').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setOutputEncodingCode({encoding: OutputEncodingCodeEnum.Auto});
        } catch (e) {
          printToOutput("setOutputEncodingCode(Auto) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setVirtualFloatingScanButton1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setVirtualFloatingScanButton({enabled: true});
        } catch (e) {
          printToOutput("setVirtualFloatingScanButton(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setVirtualFloatingScanButton0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setVirtualFloatingScanButton({enabled: false});
        } catch (e) {
          printToOutput("setVirtualFloatingScanButton(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setCenterFlagScanDisabled').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setCenterFlagScan({ mode: CenterDecodingSettingEnum.Disabled });
        } catch (e) {
          printToOutput("setCenterFlagScan(Disabled) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setCenterFlagScanCenterOnly').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setCenterFlagScan({ mode: CenterDecodingSettingEnum.CenterOnly });
        } catch (e) {
          printToOutput("setCenterFlagScan(CenterOnly) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setCenterFlagScanCenterFirst').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setCenterFlagScan({ mode: CenterDecodingSettingEnum.CenterFirst });
        } catch (e) {
          printToOutput("setCenterFlagScan(CenterFirst) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setFlash1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setFlash({enabled: false});
        } catch (e) {
          printToOutput("setFlash(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setFlash0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setFlash({enabled: false});
        } catch (e) {
          printToOutput("setFlash(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSceneDefault').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScene({scene: SpecificSceneEnum.Default});
        } catch (e) {
          printToOutput("setScene(Default) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSceneMobileScreenScene').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setScene({scene: SpecificSceneEnum.MobileScreenScene});
        } catch (e) {
          printToOutput("setScene(MobileScreenScene) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setRemoveGroupSeparator1').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setRemoveGroupSeparator({enabled: false});
        } catch (e) {
          printToOutput("setRemoveGroupSeparator(true) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setRemoveGroupSeparator0').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setRemoveGroupSeparator({enabled: false});
        } catch (e) {
          printToOutput("setRemoveGroupSeparator(false) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setPrefix').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setPrefix();
        } catch (e) {
          printToOutput("setPrefix() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setPrefixPrefix').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setPrefix({content: "prefix-"});
        } catch (e) {
          printToOutput("setPrefix(prefix-) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setPrefixCharactersRemoved').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setPrefixCharactersRemoved();
        } catch (e) {
          printToOutput("setPrefixCharactersRemoved() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setPrefixCharactersRemoved5').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setPrefixCharactersRemoved({ length: 5 });
        } catch (e) {
          printToOutput("setPrefixCharactersRemoved(5) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSuffix').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setSuffix();
        } catch (e) {
          printToOutput("setSuffix() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSuffixSuffix').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setSuffix({content: "-suffix"});
        } catch (e) {
          printToOutput("setSuffix(-suffix) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSuffixCharactersRemoved').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setSuffixCharactersRemoved();
        } catch (e) {
          printToOutput("setSuffixCharactersRemoved() - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#setSuffixCharactersRemoved5').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.setSuffixCharactersRemoved({length: 5});
        } catch (e) {
          printToOutput("setSuffixCharactersRemoved(5) - ERROR", { message: e.message, code: e.code });
        }
      });

      self.shadowRoot.querySelector('#example_normal').addEventListener('click', async function (e) {
        try {
          await SunmiScanHead.createWriteContext();
        } catch (e) {
          printToOutput("createWriteContext() - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setBroadcastConfiguration({start_intent: false, end_intent: false});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: false, end_intent: false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.Disabled});
        } catch (e) {
          printToOutput("setOutputType(Disabled) - ERROR", { message: e.message, code: e.code });
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
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.Trigger});
        } catch (e) {
          printToOutput("setTriggerMethod(TRIGGER) - ERROR", { message: e.message, code: e.code });
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
          await SunmiScanHead.setBroadcastConfiguration({start_intent: false, end_intent: false});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: false, end_intent: false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.Disabled});
        } catch (e) {
          printToOutput("setOutputType(Disabled) - ERROR", { message: e.message, code: e.code });
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
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.LongPress, sleep: 50});
        } catch (e) {
          printToOutput("setTriggerMethod(LongPress, sleep: 50) - ERROR", { message: e.message, code: e.code });
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
          await SunmiScanHead.setBroadcastConfiguration({start_intent: false, end_intent: false});
        } catch (e) {
          printToOutput("setBroadcastConfiguration(start_intent: false, end_intent: false) - ERROR", { message: e.message, code: e.code });
        }
        try {
          await SunmiScanHead.setOutputType({mode: OutputMode.Disabled});
        } catch (e) {
          printToOutput("setOutputType(Disabled) - ERROR", { message: e.message, code: e.code });
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
          await SunmiScanHead.setTriggerMethod({mode: ScanMode.Continuous, sleep: 50});
        } catch (e) {
          printToOutput("setTriggerMethod(Continuous, sleep: 50) - ERROR", { message: e.message, code: e.code });
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
