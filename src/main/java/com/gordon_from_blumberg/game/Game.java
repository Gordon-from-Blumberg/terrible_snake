package com.gordon_from_blumberg.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 16:10 011 11.06.16
 */

public interface Game {
    /**
     * Initializes the game
     */
    void init();

    /**
     * @return True if the game is running, and false otherwise
     */
    boolean isRunning();

    /**
     * Calculates the game logic and updates the game state
     */
    void updateGame();

    /**
     * Renders the game on the display
     * @param interpolation Used for smoothly animation when the FPS greater than the game speed
     */
    void renderGame(float interpolation);

    /**
     * @return The count of <code>updateGame</code> calls per second
     */
    int getTicksPerSecond();

    /**
     * @return The max count of skipped frames
     */
    int getMaxFrameSkip();
}
