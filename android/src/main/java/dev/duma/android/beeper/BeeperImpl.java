package dev.duma.android.beeper;

import android.content.Context;
import android.media.SoundPool;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import dev.duma.capacitor.sunmiscanhead.R;

public class BeeperImpl implements IBeeper {
    private final int sound;
    private final SoundPool soundPool;
    private final Vibrator vibrator;

    protected BeeperImpl(Context context) {
        SoundPool build = new SoundPool.Builder().build();

        this.soundPool = build;
        this.sound = build.load(context, R.raw.beep, 1);
        this.vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
    }

    public void beep() {
        if (this.soundPool == null) {
            return;
        }

        this.soundPool.play(this.sound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void vibrate() {
        if (this.vibrator == null) {
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.vibrator.vibrate(VibrationEffect.createOneShot(100, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            this.vibrator.vibrate(100);
        }
    }
}
