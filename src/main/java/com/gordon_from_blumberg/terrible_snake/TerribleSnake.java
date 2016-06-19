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
import com.gordon_from_blumberg.service.SettingsService;
import com.gordon_from_blumberg.service.impl.SettingsServiceImpl;

public class TerribleSnake implements Game, Configuration {

    SettingsService settingsService;

    GameCore gameCore;
    GameRenderer gameRenderer;

    private boolean running = false;

    @Override
    public void init() {
        settingsService = new SettingsServiceImpl();
        gameCore = new TerribleSnakeCore();
        gameRenderer = new TerribleSnakeRenderer();

        running = true;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void updateGame() {
        running = gameCore.update();
    }

    @Override
    public void renderGame(float interpolation) {
        gameRenderer.render(interpolation);
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
