package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:36 027 27.06.16
 */

import com.gordon_from_blumberg.game.entity.GameRootEntity;

import java.awt.*;

/**
 * Abstract game root entity drawer
 */
public abstract class AbstractGameRootEntityDrawer<RE extends GameRootEntity>
        implements GameRootEntityDrawer<RE> {

    protected Container component;

    @Override
    public Container getComponent() {
        return component;
    }
}
