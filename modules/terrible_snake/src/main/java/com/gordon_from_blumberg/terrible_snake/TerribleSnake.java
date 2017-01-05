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
import com.gordon_from_blumberg.lib.dictionary.DictionaryService;
import com.gordon_from_blumberg.lib.settings.SettingsComponent;
import com.gordon_from_blumberg.lib.utils.StringUtils;
import com.gordon_from_blumberg.terrible_snake.entity.impl.TerribleSnakeRootEntityFactory;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;

import javax.swing.*;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class TerribleSnake implements Game, Configuration {

    private static final String DEFAULT_STATE = MainMenu.STATE_KEY;

    private SettingsComponent settingsService;
    private DictionaryService dictionaryService;

    private GameRootEntityFactory rootEntityFactory;

    private String currentState;
    private GameRootEntity rootEntity;

    private JFrame frame;

    private boolean running = false;

    public TerribleSnake() {
        settingsService = ServiceHolder.getService(SettingsComponent.class);
        dictionaryService = ServiceHolder.getService(DictionaryService.class);

        rootEntityFactory = new TerribleSnakeRootEntityFactory();
    }

    @Override
    public void init() {
        frame = createFrame(settingsService.getSettings().getGraphicSettings());

        updateState(DEFAULT_STATE);

//        TerribleSnakeEntityDrawerHolder.setDrawer(
//                TerribleSnakeEntityDrawerFactory.createDrawer(DEFAULT_DRAWER_TYPE)
//        );

        ClassLoader classLoader = getClass().getClassLoader();

        try {
            String resourceName = getClass().getPackage().getName().replace(".", "/");
            URL url = classLoader.getResource(resourceName);

            String externalUrl = url.toExternalForm();

            URLConnection urlConnection = url.openConnection();

            JarFile jarFile = ((JarURLConnection) urlConnection).getJarFile();
            Path path = Paths.get(jarFile.getName());

            Enumeration<JarEntry> jarEntries = jarFile.entries();
            List<JarEntry> entryList = new ArrayList<>();

            while(jarEntries.hasMoreElements()) {
                entryList.add(jarEntries.nextElement());
            }

            List<JarEntry> onlyDirectories = entryList.stream().filter(JarEntry::isDirectory).collect(Collectors.toList());
            List<JarEntry> onlyFiles = entryList.stream().filter(entry -> !entry.isDirectory()).collect(Collectors.toList());

            System.out.print(url);
        } catch(Throwable e) {

        }

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
