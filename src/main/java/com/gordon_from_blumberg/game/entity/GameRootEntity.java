package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:22 013 13.06.16
 */

import javax.swing.*;

/**
 * Defines the root entity for each game state
 */
public interface GameRootEntity {
    /**
     * This method must be called from the main loop and it must recursively call
     * the update method of all the children entities
     *
     * @return Must return false for quit from the game, true otherwise.
     */
    boolean updateRoot();

    /**
     * Recursively renders all actual entities
     *
     * @param interpolation Interpolation for intermediate rendering
     */
    void render(float interpolation);

    /**
     * Sets the applet of this root entity as contentPane of the passed frame
     *
     * @param frame
     */
    void updateFrame(JFrame frame);
}
