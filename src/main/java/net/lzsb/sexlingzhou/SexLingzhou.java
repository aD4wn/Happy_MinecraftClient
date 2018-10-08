package net.lzsb.SexLingzhou;

import net.lzsb.SexLingzhou.clickgui.ClickGUI;
import net.lzsb.SexLingzhou.command.CommandManager;
import net.lzsb.SexLingzhou.event.EventManager;
import net.lzsb.SexLingzhou.filesystem.FileManager;
import net.lzsb.SexLingzhou.module.ModuleManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


@SideOnly(Side.CLIENT)
public class SexLingzhou {

    public static SexLingzhou CLIENT_INSTANCE;

    public static final String CLIENT_NAME = "SexLingzhou";
    public static final int CLIENT_VERSION = 1;
    public static final String CLIENT_AUTHOR = "lzsb";

    public final Logger LOGGER = LogManager.getLogger(CLIENT_NAME);

    public final ModuleManager moduleManager = new ModuleManager();
    public final EventManager eventManager = new EventManager();
    public final CommandManager commandManager = new CommandManager();
    public final FileManager fileManager = new FileManager();

    public ClickGUI clickGUI;

    public SexLingzhou() {
        CLIENT_INSTANCE = this;
    }

    public void startClient() {
        LOGGER.info(String.format("Starting %s b%d by %s", CLIENT_NAME, CLIENT_VERSION, CLIENT_AUTHOR));
        LOGGER.info("SexLingzhou by lzsb (Copyright 2017)"); // LICENSE CONDITION (MIT License)

        commandManager.registerCommands();
        moduleManager.registerModules();
        clickGUI = new ClickGUI();
        eventManager.registerListener(moduleManager);

        try{
            fileManager.loadModules();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void stopClient() {
        try{
            fileManager.saveModules();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}