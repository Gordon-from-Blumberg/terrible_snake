package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 2:22 003 03.07.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.game.entity.GameEntity;

public class TerribleSnakeEntityDrawerFactory implements GameEntityDrawerFactory {
    private final String DRAWER_PACKAGE = getClass().getPackage().toString();

    @Override
    public <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType) {
        System.out.println("DRAWER_PACKAGE = " + DRAWER_PACKAGE);
        return null;
    }
}
