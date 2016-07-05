package com.gordon_from_blumberg.terrible_snake.entity.menu.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:04 015 15.06.16
 */

import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.game.entity.AbstractGameRootEntity;
import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuContainer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Map;

public class MainMenuImpl
        extends AbstractGameRootEntity
        implements MainMenu {

    final private LinkedList<MouseEvent> events = new LinkedList<>();
    final private MenuContainer container;

    public MainMenuImpl(Map<String, String> args) {
        super(args);
        container = new MenuContainerImpl();
        createDrawers(new TerribleSnakeEntityDrawerFactory("tetris")); //todo remove magic string constant
        System.out.println("Main menu is created!");
    }

    @Override
    public String updateRoot() {
        container.update();
        return getStateCode();
    }

    @Override
    public void createDrawers(GameEntityDrawerFactory drawerFactory) {
        container.createDrawer(drawerFactory, applet);
    }

    @Override
    public void render(float interpolation) {
        container.render(interpolation);
    }

    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            events.add(e);
        }
    }
}
