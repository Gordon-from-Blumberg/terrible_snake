package com.gordon_from_blumberg.terrible_snake.entity.menu.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:25 006 06.07.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuContainer;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuItem;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuContainerImpl implements MenuContainer {
    private AbstractGameEntityDrawer<MenuContainer> drawer;
    private List<MenuItem> children = new ArrayList<>();

    @Override
    public void update() {
        children.forEach(MenuItem::update);
    }

    @Override
    public void render(float interpolation) {
        drawer.draw(interpolation);
        children.forEach(child -> child.render(interpolation));
    }

    @Override
    public void createDrawer(GameEntityDrawerFactory drawerFactory, Container parentDrawer) {
        drawer = drawerFactory.createDrawerFor(MenuContainer.class, this);
    }
}
