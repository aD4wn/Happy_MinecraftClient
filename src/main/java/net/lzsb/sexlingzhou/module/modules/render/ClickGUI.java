package net.lzsb.SexLingzhou.module.modules.render;

import net.lzsb.SexLingzhou.SexLingzhou;
import net.lzsb.SexLingzhou.module.Module;
import net.lzsb.SexLingzhou.module.ModuleCategory;
import net.lzsb.SexLingzhou.module.ModuleInfo;

/**
 * Copyright © 2015 - 2017 | lzsb | All rights reserved.
 * <p>
 * SexLingzhou - By lzsb(Marco)
 */
@ModuleInfo(moduleName = "ClickGUI", moduleDescription = "", moduleCateogry = ModuleCategory.RENDER, canEnable = false)
public class ClickGUI extends Module {

    @Override
    public void onEnable() {
        mc.displayGuiScreen(SexLingzhou.CLIENT_INSTANCE.clickGUI);
    }
}