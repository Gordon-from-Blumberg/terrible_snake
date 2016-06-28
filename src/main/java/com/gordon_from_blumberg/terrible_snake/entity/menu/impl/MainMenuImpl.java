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
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class MainMenuImpl
        extends AbstractGameRootEntity
        implements MainMenu {

    final private LinkedList<MouseEvent> events = new LinkedList<>();

    @Override
    public boolean updateRoot() {
        while(!events.isEmpty()) {
            events.pop();
        }
        return true;
    }

    @Override
    public void createDrawers(GameEntityDrawerFactory drawerFactory) {

    }

    @Override
    public void render(float interpolation) {

    }

    public class MouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            events.add(e);
        }
    }
}
