package dev.duma.android.sunmi.scantriggercontrol;

import android.content.Context;

public interface ITriggerControlHelper {
    void enable();

    void disable();

    class Factory
    {
        static public ITriggerControlHelper make(Context context) {
            return new TriggerControlHelper(context);
        }
    }
}
