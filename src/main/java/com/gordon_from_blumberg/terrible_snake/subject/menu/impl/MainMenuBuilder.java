package com.gordon_from_blumberg.terrible_snake.subject.menu.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:40 015 15.06.16
 */

import com.gordon_from_blumberg.game.subject.GameRootSubjectBuilder;

/**
 * The builder of main menu
 */
public class MainMenuBuilder implements GameRootSubjectBuilder<MainMenu> {
    @Override
    public MainMenu build() {
        return new MainMenu();
    }
}
