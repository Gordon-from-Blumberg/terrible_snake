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
     * Creates the drawer instance of the specified entity type
     *
     * @param entityType Type of the entity for drawing
     * @param entity Entity for drawing
     * @param <E> Interface of the entity for drawing
     * @return Created drawer for the specified entity
     */
    <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType, E entity);
}
