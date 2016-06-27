package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:44 026 26.06.16
 */

import com.gordon_from_blumberg.game.drawer.GameEntityDrawer;

/**
 * Abstract game entity
 */
public abstract class AbstractGameEntity implements GameEntity {
    protected GameEntityDrawer drawer;

    @Override
    public void render(float interpolation) {
        drawer.draw(interpolation, this);
    }

}
