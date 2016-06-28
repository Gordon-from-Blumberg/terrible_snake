package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:44 028 28.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

/**
 * Factory for the creating of the entity drawers
 */
public interface GameEntityDrawerFactory {
    /**
     * Creates the instance of the specified drawer type
     *
     * @param entityType Class object of the required drawer interface
     * @param <E>        Interface of the required drawer
     * @return Created drawer for the specified type of entity
     */
    <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType);
}
