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

/**
 * Defines object that draws the corresponding entity
 * @param <E> The game entity which is drawn by this drawer
 */
public interface GameEntityDrawer<E extends GameEntity> {
    /**
     * Draws the entity
     *
     * @param interpolation Interpolation
     */
    void draw(float interpolation);

    /**
     * @return The entity object that uses this drawer
     */
    E getEntity();
}
