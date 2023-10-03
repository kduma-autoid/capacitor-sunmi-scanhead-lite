package dev.duma.capacitor.sunmibarcodescanner;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Base64;
import java.util.Objects;

public class SunmiBarcodeScannerBroadcastReceiver {
    public interface ScanCallback {
        void onScan(String data, String source_bytes);

        void onStart();
        void onStop();
    }

    private final Context context;

    private final ScanCallback callback;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch(Objects.requireNonNull(intent.getAction())) {
                case "com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED":
                    String code = intent.getStringExtra("data");
                    byte[] sourceBytes = intent.getByteArrayExtra("source_byte");
                    String source_byte = Base64.encodeToString(sourceBytes, Base64.NO_WRAP);

                    if (code != null && !code.isEmpty()) {
                        callback.onScan(code, source_byte);
                    }
                    break;

                case "com.sunmi.scanner.ACTION_SCAN_START":
                    callback.onStart();
                    break;

                case "com.sunmi.scanner.ACTION_SCAN_END":
                    callback.onStop();
                    break;
            }
        }
    };

    public SunmiBarcodeScannerBroadcastReceiver(Context context, ScanCallback callback) {
        this.context = context;
        this.callback = callback;
    }

    @SuppressLint("UnspecifiedRegisterReceiverFlag")
    public void register() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("com.sunmi.scanner.ACTION_DATA_CODE_RECEIVED");
        filter.addAction("com.sunmi.scanner.ACTION_SCAN_END");
        filter.addAction("com.sunmi.scanner.ACTION_SCAN_START");

        context.registerReceiver(receiver, filter);
    }

    public void unregister() {
        try {
            context.unregisterReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
