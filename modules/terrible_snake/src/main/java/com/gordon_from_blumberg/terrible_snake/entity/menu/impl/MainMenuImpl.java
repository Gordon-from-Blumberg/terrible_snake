package com.gordon_from_blumberg.terrible_snake.entity.menu.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:04 015 15.06.16
 */

import com.gordon_from_blumberg.game.entity.AbstractGameRootEntity;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuContainer;

import java.util.Map;

public class MainMenuImpl
        extends AbstractGameRootEntity
        implements MainMenu {

    private final MenuContainer container;

    public MainMenuImpl(Map<String, String> args) {
        super(args);
        container = new MenuContainerImpl();
        System.out.println("Main menu is created!");
    }

    @Override
    public String updateRoot() {
        container.update();
        return getStateCode();
    }

    @Override
    public void render(float interpolation) {
        container.render(interpolation);
    }
}
