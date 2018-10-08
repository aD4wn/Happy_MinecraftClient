package net.lzsb.SexLingzhou.command.commands;

import net.lzsb.SexLingzhou.command.Command;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleManager;
import net.lzsb.SexLingzhou.utils.ChatUtils;

/**
 * Copyright © 2015 - 2017 | lzsb | All rights reserved.
 * <p>
 * SexLingzhou - By lzsb(Marco)
 */
public class ToggleCommand extends Command {

    public ToggleCommand() {
        super("toggle");
    }

    @Override
    public void execute(String[] strings) {
        if(strings.length > 1) {
            final Module module = ModuleManager.getModule(strings[1]);

            if(module == null) {
                ChatUtils.displayMessage("§c§lError: §r§aThe entered module not exist.");
                return;
            }

            module.setState(!module.getState());
            ChatUtils.displayMessage("§cToggled module.");
            return;
        }

        ChatUtils.displayMessage("§c§lSyntax: §r§a.toggle <module>");
    }
}
