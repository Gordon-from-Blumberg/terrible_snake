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
import com.gordon_from_blumberg.game.entity.GameRootEntityFactory;
import com.gordon_from_blumberg.game.settings.GraphicSettings;
import com.gordon_from_blumberg.service.DictionaryService;
import com.gordon_from_blumberg.service.ServiceHolder;
import com.gordon_from_blumberg.service.SettingsService;
import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawerHolder;
import com.gordon_from_blumberg.terrible_snake.entity.impl.TerribleSnakeRootEntityFactory;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;
import com.gordon_from_blumberg.utils.StringUtils;

import javax.swing.*;

public class TerribleSnake implements Game, Configuration {

    private static final String DEFAULT_STATE = MainMenu.STATE_KEY;

    private SettingsService settingsService;
    private DictionaryService dictionaryService;

    private GameRootEntityFactory rootEntityFactory;

    private String currentState;
    private GameRootEntity rootEntity;

    private JFrame frame;

    private boolean running = false;

    public TerribleSnake() {
        settingsService = ServiceHolder.getSettingsService();
        dictionaryService = ServiceHolder.getDictionaryService();

        rootEntityFactory = new TerribleSnakeRootEntityFactory();
    }

    @Override
    public void init() {
        frame = createFrame(settingsService.getSettings().getGraphicSettings());

        updateState(DEFAULT_STATE);

        TerribleSnakeEntityDrawerHolder.setDrawer(
                TerribleSnakeEntityDrawerFactory.createDrawer(DEFAULT_DRAWER_TYPE)
        );

        running = true;
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    @Override
    public void updateGame() {
        String newState = rootEntity.updateRoot();

        if (!currentState.equals(newState)) {
            if (StringUtils.isBlank(newState)) {
                running = false;
            } else {
                updateState(newState);
            }
        }
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

    private void updateState(String newState) {
        currentState = newState;
        rootEntity = rootEntityFactory.create(currentState);
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
