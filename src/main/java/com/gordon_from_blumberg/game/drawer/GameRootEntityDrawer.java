package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:36 020 20.06.16
 */

import com.gordon_from_blumberg.game.entity.GameRootEntity;

import java.awt.*;

/**
 * The drawer for root entity
 *
 * @param <RE> The root entity
 */
public interface GameRootEntityDrawer<RE extends GameRootEntity> {
    /**
     * Draws the rootEntity
     *
     * @param interpolation Interpolation
     * @param rootEntity    Root entity for drawing
     */
    void draw(float interpolation, RE rootEntity);

    /**
     * @return Component appropriate to the entity instance referencing to this drawer
     */
    Container getComponent();
}
