package net.lzsb.SexLingzhou.command.commands;

import net.lzsb.SexLingzhou.command.Command;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleManager;
import net.lzsb.SexLingzhou.utils.ChatUtils;
import org.lwjgl.input.Keyboard;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public class BindCommand extends Command {

    public BindCommand() {
        super("bind");
    }

    @Override
    public void execute(String[] strings) {
        if(strings.length > 2) {
            final Module module = ModuleManager.getModule(strings[1]);

            if(module == null) {
                ChatUtils.displayMessage("§c§lError: §r§aThe entered module not exist.");
                return;
            }

            final int key = Keyboard.getKeyIndex(strings[2].toUpperCase());

            module.setKeyBind(key);
            ChatUtils.displayMessage("§cThe keybind of §a§l" + module.getModuleName() + " §r§cwas set to §a§l" + Keyboard.getKeyName(key) + "§c.");
            return;
        }

        ChatUtils.displayMessage("§c§lSyntax: §r§a.bind <module> <key>");
    }
}