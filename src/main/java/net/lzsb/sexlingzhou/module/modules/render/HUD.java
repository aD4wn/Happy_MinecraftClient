package net.lzsb.SexLingzhou.module.modules.render;

import net.lzsb.SexLingzhou.SexLingzhou;
import net.lzsb.SexLingzhou.event.EventTarget;
import net.lzsb.SexLingzhou.event.events.Render2DEvent;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleCategory;
import net.lzsb.SexLingzhou.module.ModuleInfo;
import net.lzsb.SexLingzhou.module.ModuleManager;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;

@ModuleInfo(moduleName = "HUD", moduleDescription = "bla", moduleCateogry = ModuleCategory.RENDER, defaultKey = Keyboard.KEY_U)
public class HUD extends Module {

    public HUD() {
        setState(true);
    }

    @EventTarget
    public void onRender2D(final Render2DEvent event) {
        if(!getState())
            return;

        final FontRenderer fontRenderer = mc.fontRendererObj;
        final ScaledResolution scaledResolution = new ScaledResolution(mc);

        GlStateManager.scale(2, 2, 2);
        fontRenderer.drawString(SexLingzhou.CLIENT_NAME, 2, 2, 0x8CFF48, true);
        GlStateManager.scale(0.5, 0.5, 0.5);

        final int[] yDist = {2};
        ModuleManager.getModules().stream().filter(Module :: getState).sorted(Comparator.comparingInt(module -> -fontRenderer.getStringWidth(module.getModuleName()))).forEach(module -> {
            fontRenderer.drawString(module.getModuleName(), scaledResolution.getScaledWidth() - 2 - fontRenderer.getStringWidth(module.getModuleName()), yDist[0], 0x8CFF48, true);
            yDist[0] += fontRenderer.FONT_HEIGHT;
        });
    }
}