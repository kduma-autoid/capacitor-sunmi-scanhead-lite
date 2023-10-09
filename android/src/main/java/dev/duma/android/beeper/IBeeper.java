package dev.duma.android.beeper;

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
        static public IBeeper make() {
            return new IBeeper.Stub();
        }

        static public IBeeper make(Context context) {
            return new BeeperImpl(context);
        }
    }

    class Stub implements IBeeper
    {
        protected Stub() {
        }

        @Override
        public void beep() {
            // Do Nothing
        }

        @Override
        public void vibrate() {
            // Do Nothing
        }
    }
}
