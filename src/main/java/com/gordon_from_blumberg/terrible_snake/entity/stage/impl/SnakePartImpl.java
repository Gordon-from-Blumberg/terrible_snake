package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:26 012 12.06.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.stage.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Grid;
import com.gordon_from_blumberg.terrible_snake.entity.stage.SnakePart;

import java.awt.*;

public class SnakePartImpl extends AbstractGridElement implements SnakePart {
    private AbstractGameEntityDrawer<SnakePart> drawer;

    public SnakePartImpl(Grid.GridCell gridCell) {
        super(gridCell);
    }

    @Override
    public void moveTo(Grid.GridCell gridCell) {
        setGridCell(gridCell);
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
        drawer = drawerFactory.createDrawerFor(SnakePart.class);
        parentDrawer.add(drawer);
    }
}
