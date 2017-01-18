package com.gordon_from_blumberg.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 16:10 011 11.06.16
 */

/**
 * Entry point object of the game
 */
public class Game {
    private final int SKIP_TICKS;
    private final int MAX_FRAME_SKIP;

    private boolean running = false;

    //todo
    public Game() {
        SKIP_TICKS = 10;
        MAX_FRAME_SKIP = 10;
    }

    public void run() {
        running = true;

        long nextGameTick = System.currentTimeMillis();
        long prevGameTick = nextGameTick - SKIP_TICKS;

        try {
            while(running) {
                int skippedFrames = 0;

                while(System.currentTimeMillis() > nextGameTick && skippedFrames < MAX_FRAME_SKIP) {
                    update();

                    prevGameTick = nextGameTick;
                    nextGameTick += SKIP_TICKS;
                    skippedFrames++;
                }

                render(interpolate(prevGameTick, SKIP_TICKS));
            }
        } catch(Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Calculates the game logic and updates the game state
     */
    private void update() {
        running = false;
    }

    /**
     * Renders the game on the display
     *
     * @param interpolation Used for smoothly animation when the FPS greater than the game speed
     */
    private void render(float interpolation) {

    }

    private float interpolate(long prevGameTick, int skipTicks) {
        float currentTick = (float) (System.currentTimeMillis() - prevGameTick);
        return currentTick / skipTicks;
    }
}
