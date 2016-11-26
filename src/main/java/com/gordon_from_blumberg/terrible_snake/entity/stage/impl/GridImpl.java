package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 1:03 017 17.06.16
 */

import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawerHolder;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Grid;

public class GridImpl implements Grid {
    private Grid.GridCell[][] grid;

    @Override
    public GridCell getCell(int x, int y) {
        try {
            return grid[x][y];
        } catch(ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(String.format("Illegal coordinates: %s, %s", x, y), e);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {
        TerribleSnakeEntityDrawerHolder.getDrawer().drawGrid(this, interpolation);
    }
}
