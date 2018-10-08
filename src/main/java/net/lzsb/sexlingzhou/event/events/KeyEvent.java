package net.lzsb.SexLingzhou.event.events;

import net.lzsb.SexLingzhou.event.Event;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public class KeyEvent extends Event {

    private int key;

    public KeyEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}