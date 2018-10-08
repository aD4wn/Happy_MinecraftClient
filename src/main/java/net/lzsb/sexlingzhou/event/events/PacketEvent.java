package net.lzsb.SexLingzhou.event.events;

import net.lzsb.SexLingzhou.event.CancellableEvent;
import net.minecraft.network.Packet;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public class PacketEvent extends CancellableEvent {

    private Packet packet;

    public PacketEvent(Packet packet) {
        this.packet = packet;
    }

    public Packet getPacket() {
        return packet;
    }
}