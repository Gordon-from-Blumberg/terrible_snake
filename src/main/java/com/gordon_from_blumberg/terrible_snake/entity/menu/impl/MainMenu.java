package com.gordon_from_blumberg.terrible_snake.entity.menu.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:04 015 15.06.16
 */

import com.gordon_from_blumberg.game.entity.GameRootEntity;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class MainMenu implements GameRootEntity {
    final private LinkedList<MouseEvent> events = new LinkedList<>();

    @Override
    public void update() {
        while(!events.isEmpty()) {
            events.pop();
        }
    }

    @Override
    public boolean updateRoot() {
        return false;
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
