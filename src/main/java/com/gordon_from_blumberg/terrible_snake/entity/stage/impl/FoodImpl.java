package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:33 014 14.06.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.stage.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Food;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Grid;

import java.awt.*;

public class FoodImpl extends AbstractGridElement implements Food {
    private AbstractGameEntityDrawer<Food> drawer;

    public FoodImpl(Grid.GridCell gridCell) {
        super(gridCell);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {
        drawer.draw(interpolation);
    }

    @Override
    public void createDrawer(GameEntityDrawerFactory drawerFactory, Container parentDrawer) {
        drawer = drawerFactory.createDrawerFor(Food.class);
        parentDrawer.add(drawer);
    }
}
