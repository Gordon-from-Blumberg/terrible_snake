package com.gordon_from_blumberg.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:19 011 11.06.16
 */

/**
 * An object that implements this interface is responsible for rendering
 */
public interface GameRenderer {
    /**
     * Renders the game on the display
     * @param interpolation Used for the rendering of the intermediate state
     */
    void render(float interpolation);
}
