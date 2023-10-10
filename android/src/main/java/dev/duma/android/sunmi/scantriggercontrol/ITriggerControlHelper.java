package dev.duma.android.sunmi.scantriggercontrol;

import android.content.Context;

public interface ITriggerControlHelper {
    void set(boolean enabled);

    class Factory
    {
        static public ITriggerControlHelper make(Context context) {
            return new TriggerControlHelper(context);
        }
    }
}
