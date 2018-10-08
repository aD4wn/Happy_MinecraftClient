package net.lzsb.SexLingzhou.module;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
public enum ModuleCategory {

    PLAYER("Player"), COMBAT("Combat"), MOVEMENT("Movement"), WORLD("World"), MISC("Misc"), EXPLOIT("Exploit"), RENDER("Render");

    private String name;

    ModuleCategory(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}