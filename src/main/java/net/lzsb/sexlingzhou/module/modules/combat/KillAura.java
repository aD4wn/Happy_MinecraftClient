package net.lzsb.SexLingzhou.module.modules.combat;

import net.lzsb.SexLingzhou.event.EventTarget;
import net.lzsb.SexLingzhou.event.events.MotionUpdateEvent;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleCategory;
import net.lzsb.SexLingzhou.module.ModuleInfo;
import net.lzsb.SexLingzhou.valuesystem.Value;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import org.lwjgl.input.Keyboard;

import java.util.Comparator;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 * Inspired by Liquid and Zues
 */
@ModuleInfo(moduleName = "KillAura", moduleDescription = "Attack entitys around you.", moduleCateogry = ModuleCategory.COMBAT, defaultKey = Keyboard.KEY_R)
public class KillAura extends Module {

    private EntityLivingBase target;

    private Value<Float> rangeValue = new Value<>("Range", 4.2F);

    @EventTarget
    public void onMotion(MotionUpdateEvent event) {
        if(!getState())
            return;

        switch(event.getState()) {
            case PRE:
                Object[] objects = mc.theWorld.loadedEntityList.stream().filter(entity -> entity instanceof EntityLivingBase && entity != mc.thePlayer && ((EntityLivingBase) entity).getHealth() > 0F && entity.getDistanceToEntity(mc.thePlayer) <= rangeValue.getObject()).sorted(Comparator.comparingDouble(entity -> entity.getDistanceToEntity(mc.thePlayer))).toArray();

                if(objects.length > 0)
                    target = (EntityLivingBase) objects[0];

                // Your facing etc here then
                break;
            case POST:
                if(target == null)
                    return;

                mc.thePlayer.swingItem();
                mc.getNetHandler().addToSendQueue(new C02PacketUseEntity(target, C02PacketUseEntity.Action.ATTACK));

                target = null;
                break;
        }
    }
}
