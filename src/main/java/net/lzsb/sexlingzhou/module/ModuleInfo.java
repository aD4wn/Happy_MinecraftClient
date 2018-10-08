package net.lzsb.SexLingzhou.module;

import org.lwjgl.input.Keyboard;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Project: SexLingzhou
 * -----------------------------------------------------------
 * Copyright © 2017 | lzsb | All rights reserved.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface ModuleInfo {

    String moduleName();
    String moduleDescription();
    ModuleCategory moduleCateogry();
    int defaultKey() default Keyboard.KEY_NONE;
    boolean canEnable() default true;

}
