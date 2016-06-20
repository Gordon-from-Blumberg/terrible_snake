package com.gordon_from_blumberg.terrible_snake.entity.game.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:30 015 15.06.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.game.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.game.Grid;
import com.gordon_from_blumberg.terrible_snake.entity.game.Obstacle;

public class ObstacleImpl extends AbstractGridElement implements Obstacle {
    public ObstacleImpl(Grid.GridCell gridCell) {
        super(gridCell);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {

    }
}
