package com.gordon_from_blumberg.terrible_snake.entity.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:41 014 14.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

public interface GridElementEntity extends GameEntity {
    /**
     * @return X coordinate of the entity on the grid
     */
    int getX();

    /**
     * Sets new X coordinate of the entity on the grid
     *
     * @param x New value of X coordinate
     */
    void setX(int x);

    /**
     * @return Y coordinate of the entity on the grid
     */
    int getY();

    /**
     * Sets new Y coordinate of the entity on the grid
     *
     * @param y New value of Y coordinate
     */
    void setY(int y);
}
