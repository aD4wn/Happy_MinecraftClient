package net.lzsb.SexLingzhou.injection.mixins;

import net.lzsb.SexLingzhou.event.EventManager;
import net.lzsb.SexLingzhou.event.events.Render2DEvent;
import net.minecraft.client.gui.GuiSpectator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
@Mixin(GuiSpectator.class)
public class MixinGuiSpectator {

    @Inject(method = "renderTooltip", at = @At("RETURN"))
    private void render2D(CallbackInfo callbackInfo) {
        EventManager.callEvent(new Render2DEvent());
    }
}