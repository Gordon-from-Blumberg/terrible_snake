package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:22 012 12.06.16
 */

import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;

import java.awt.*;

/**
 * Defines the game entity that must be updated every tick
 */
public interface GameEntity {
    /**
     * Updates the state of this entity on the current tick
     */
    void update();

    /**
     * Renders this entity
     *
     * @param interpolation Interpolation for intermediate rendering
     */
    void render(float interpolation);

    /**
     * Uses the passed drawer factory for creating of drawer
     *
     * @param drawerFactory Current drawer factory
     * @param parentDrawer  The drawer object of the parent entity
     */
    void createDrawer(GameEntityDrawerFactory drawerFactory, Container parentDrawer);
}
