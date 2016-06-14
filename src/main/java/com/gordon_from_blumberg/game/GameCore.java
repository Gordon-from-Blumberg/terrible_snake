package com.gordon_from_blumberg.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:04 011 11.06.16
 */

/**
 * An object that implements this interface is responsible for game logic
 */
public interface GameCore {
    /**
     * Calculates the game logic
     * @return True if the game is running and false otherwise
     */
    boolean update();
}
