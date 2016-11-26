package com.gordon_from_blumberg.terrible_snake.entity.stage;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:41 014 14.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

/**
 * Defines the game element on the grid
 */
public interface GridElement extends GameEntity {
    /**
     * @return X coordinate of the entity on the grid
     */
    int getX();

    /**
     * @return Y coordinate of the entity on the grid
     */
    int getY();

    /**
     * @return The grid cell object on which this grid element stays
     */
    Grid.GridCell getGridCell();
}
