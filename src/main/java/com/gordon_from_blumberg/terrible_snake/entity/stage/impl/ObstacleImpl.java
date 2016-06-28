package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:30 015 15.06.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.stage.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Grid;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Obstacle;

import java.awt.*;

public class ObstacleImpl extends AbstractGridElement implements Obstacle {
    private AbstractGameEntityDrawer<Obstacle> drawer;

    public ObstacleImpl(Grid.GridCell gridCell) {
        super(gridCell);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {

    }

    @Override
    public void createDrawer(GameEntityDrawerFactory drawerFactory, Container parentDrawer) {
        drawer = drawerFactory.createDrawerFor(Obstacle.class);
        parentDrawer.add(drawer);
    }
}
