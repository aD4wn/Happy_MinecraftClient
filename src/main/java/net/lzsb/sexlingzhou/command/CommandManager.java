package net.lzsb.SexLingzhou.command;

import net.lzsb.SexLingzhou.command.commands.BindCommand;
import net.lzsb.SexLingzhou.command.commands.ToggleCommand;
import net.lzsb.SexLingzhou.command.commands.ValueCommand;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
@SideOnly(Side.CLIENT)
public class CommandManager {

    private final List<Command> commands = new ArrayList<>();

    public void registerCommands() {
        registerCommand(new BindCommand());
        registerCommand(new ValueCommand());
        registerCommand(new ToggleCommand());
    }

    public void registerCommand(final Command command) {
        commands.add(command);
    }

    public void callCommand(final String s) {
        final String[] strings = s.split(" ");
        commands.stream().filter(command -> strings[0].equalsIgnoreCase("." + command.getName())).forEach(command -> command.execute(strings));
    }
}