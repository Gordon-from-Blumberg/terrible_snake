package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:22 013 13.06.16
 */

import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;

import javax.swing.*;

/**
 * Defines the root entity for each game state
 */
public interface GameRootEntity {
    /**
     * This method must be called from the main loop and it must recursively call
     * the update method of all the children entities
     *
     * @return State key. If it differs from current state the new root entity
     * will be created. Return blank string or null to stop the game
     */
    String updateRoot();

    /**
     * Recursively renders all actual entities
     *
     * @param interpolation Interpolation for intermediate rendering
     */
    void render(float interpolation);

    /**
     * Creates drawers for the all actual entities
     * @param drawerFactory Factory that creates drawers
     */
    void createDrawers(GameEntityDrawerFactory drawerFactory);

    /**
     * Sets the applet of this root entity as contentPane of the passed frame
     *
     * @param frame Frame update
     */
    void updateFrame(JFrame frame);

    /**
     * Returns the state key that has been used for creating of this root entity
     *
     * @return State key of this root entity
     */
    String getStateCode();
}
