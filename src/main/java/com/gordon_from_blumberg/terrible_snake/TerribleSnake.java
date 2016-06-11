package com.gordon_from_blumberg.terrible_snake;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 16:15 011 11.06.16
 */

import com.gordon_from_blumberg.game.Game;
import com.gordon_from_blumberg.game.GameCore;
import com.gordon_from_blumberg.game.GameRenderer;

public class TerribleSnake implements Game {

    private static final int TICKS_PER_SECOND = 25;
    private static final int MAX_FRAME_SKIP = 5;

    GameCore gameCore;
    GameRenderer gameRenderer;

    private boolean running = false;

    @Override
    public void init() {

    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void updateGame() {

    }

    @Override
    public void renderGame(float interpolation) {

    }

    @Override
    public int getTicksPerSecond() {
        return TICKS_PER_SECOND;
    }

    @Override
    public int getMaxFrameSkip() {
        return MAX_FRAME_SKIP;
    }
}
