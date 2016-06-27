package com.gordon_from_blumberg.terrible_snake.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:54 028 28.06.16
 */

import com.gordon_from_blumberg.game.entity.GameRootEntity;
import com.gordon_from_blumberg.terrible_snake.drawer.AbstractTerribleSnakeDrawerFactory;

/**
 * Defines the root entity of one Terrible Snake game state
 */
public interface TerribleSnakeRootEntity extends GameRootEntity {
    void createDrawers(AbstractTerribleSnakeDrawerFactory drawerFactory);
}
