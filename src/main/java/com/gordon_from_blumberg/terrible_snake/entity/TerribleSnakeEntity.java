package com.gordon_from_blumberg.terrible_snake.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:39 026 26.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;
import com.gordon_from_blumberg.terrible_snake.drawer.AbstractDrawerFactory;

/**
 * Defines the root entity of one Terrible Snake game state
 */
public interface TerribleSnakeEntity extends GameEntity {
    /**
     * Uses the passed drawer factory for creating of drawer
     *
     * @param drawerFactory Current drawer factory
     */
    void createDrawer(AbstractDrawerFactory drawerFactory);
}
