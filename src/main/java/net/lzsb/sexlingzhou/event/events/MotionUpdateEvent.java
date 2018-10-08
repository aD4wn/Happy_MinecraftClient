package net.lzsb.SexLingzhou.event.events;

import net.lzsb.SexLingzhou.event.Event;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public class MotionUpdateEvent extends Event {

    private State state;

    public MotionUpdateEvent(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public enum State {
        PRE, POST;
    }
}