package com.gordon_from_blumberg.terrible_snake.entity.game.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:26 012 12.06.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.game.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.game.Grid;
import com.gordon_from_blumberg.terrible_snake.entity.game.SnakePart;

public class SnakePartImpl extends AbstractGridElement implements SnakePart {
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
}
