package com.gordon_from_blumberg.game.drawer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:48 027 27.11.16
 */

/**
 * Annotation for marking entity drawer. Every class implementing {@link com.gordon_from_blumberg.game.drawer.GameEntityDrawer}
 * should be annotated by this.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EntityDrawer {
    String name();
}
