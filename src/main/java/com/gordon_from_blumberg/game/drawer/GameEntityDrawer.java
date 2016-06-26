package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:41 013 13.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

import java.awt.*;

/**
 * Defines object that draws the corresponding entity
 * @param <E> The game entity which is drawn by this drawer
 */
public interface GameEntityDrawer<E extends GameEntity> {
    /**
     * Draws the entity
     *
     * @param interpolation Interpolation
     * @param entity Entity for drawing
     */
    void draw(float interpolation, E entity);

    /**
     * @return Component appropriate to the entity instance referencing to this drawer
     */
    Container getComponent();
}
