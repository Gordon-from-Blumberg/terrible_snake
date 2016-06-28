package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:06 028 28.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

/**
 * Abstract factory of the entity drawers
 */
public abstract class AbstractGameEntityDrawerFactory
        implements GameEntityDrawerFactory {

    //todo use groovy script for the drawer instance creating

    @Override
    public <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType) {
        return null;
    }
}
