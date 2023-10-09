package dev.duma.android.sunmi.beeper;

import android.content.Context;

public interface IBeeper {
    /**
     * Make a scan beep
     */
    void beep();

    /**
     * Vibrate a device
     */
    void vibrate();


    class Factory
    {
        static public IBeeper make(Context context) {
            return new Beeper(context);
        }
    }
}
