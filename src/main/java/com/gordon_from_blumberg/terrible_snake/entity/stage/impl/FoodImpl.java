package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:33 014 14.06.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.stage.AbstractGridElement;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Food;
import com.gordon_from_blumberg.terrible_snake.entity.stage.Grid;

public class FoodImpl extends AbstractGridElement implements Food {
    public FoodImpl(Grid.GridCell gridCell) {
        super(gridCell);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {

    }
}
