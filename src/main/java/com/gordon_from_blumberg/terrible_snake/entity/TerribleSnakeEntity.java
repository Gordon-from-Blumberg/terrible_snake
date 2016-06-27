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
import com.gordon_from_blumberg.terrible_snake.drawer.AbstractTerribleSnakeDrawerFactory;

import java.awt.*;

/**
 * Defines the entity of one Terrible Snake game
 */
public interface TerribleSnakeEntity extends GameEntity {
    /**
     * Uses the passed drawer factory for creating of drawer
     *
     * @param drawerFactory Current drawer factory
     * @param parentDrawer The drawer object of the parent entity
     */
    void createDrawer(AbstractTerribleSnakeDrawerFactory drawerFactory, Container parentDrawer);
}
