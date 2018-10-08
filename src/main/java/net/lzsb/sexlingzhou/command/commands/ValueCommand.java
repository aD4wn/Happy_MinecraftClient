package net.lzsb.SexLingzhou.command.commands;

import net.lzsb.SexLingzhou.command.Command;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleManager;
import net.lzsb.SexLingzhou.utils.ChatUtils;
import net.lzsb.SexLingzhou.valuesystem.Value;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public class ValueCommand extends Command {

    public ValueCommand() {
        super("value");
    }

    @Override
    public void execute(String[] strings) {
        if(strings.length > 3) {
            final Module module = ModuleManager.getModule(strings[1]);

            if(module == null) {
                ChatUtils.displayMessage("§c§lError: §r§aThe entered module not exist.");
                return;
            }

            final Value value = module.getValue(strings[2]);

            if(value == null) {
                ChatUtils.displayMessage("§c§lError: §r§aThe entered value not exist.");
                return;
            }

            if(value.getObject() instanceof Float) {
                final float newValue = Float.parseFloat(strings[3]);
                value.setObject(newValue);
                ChatUtils.displayMessage("§cThe value of §a§l" + module.getModuleName() + " §8(§a§l" + value.getValueName() + ") §c was set to §a§l" + newValue + "§c.");
            }
            return;
        }

        ChatUtils.displayMessage("§c§lSyntax: §r§a.value <module> <valuename> <new_value>");
    }
}