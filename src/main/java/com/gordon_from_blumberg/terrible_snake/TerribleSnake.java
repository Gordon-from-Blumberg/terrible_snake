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
import com.gordon_from_blumberg.game.entity.GameRootEntity;
import com.gordon_from_blumberg.game.settings.GraphicSettings;
import com.gordon_from_blumberg.service.DictionaryService;
import com.gordon_from_blumberg.service.ServiceManager;
import com.gordon_from_blumberg.service.SettingsService;

import javax.swing.*;

public class TerribleSnake implements Game, Configuration {

    private SettingsService settingsService;
    private DictionaryService dictionaryService;

    private TerribleSnakeStageBuilder stageBuilder = new TerribleSnakeStageBuilder();
    private MainMenuBuilder menuBuilder = new MainMenuBuilder();

    private GameRootEntity rootEntity;

    private JFrame frame;

    private boolean running = false;

    @Override
    public void init() {
        settingsService = ServiceManager.getSettingsService();
        dictionaryService = ServiceManager.getDictionaryService();
        rootEntity = menuBuilder.build();

        frame = createFrame(settingsService.getSettings().getGraphicSettings());
        running = true;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void updateGame() {
        running = rootEntity.updateRoot();
    }

    @Override
    public void renderGame(float interpolation) {
        rootEntity.render(interpolation);
    }

    @Override
    public int getTicksPerSecond() {
        return TICKS_PER_SECOND;
    }

    @Override
    public int getMaxFrameSkip() {
        return MAX_FRAME_SKIP;
    }

    private JFrame createFrame(GraphicSettings graphicSettings) {
        JFrame frame = new JFrame(dictionaryService.getMessage("frameTitle"));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setIgnoreRepaint(true);
        frame.setSize(graphicSettings.getScreenWidth(), graphicSettings.getScreenHeight());

        frame.setVisible(true);

        return frame;
    }
}
