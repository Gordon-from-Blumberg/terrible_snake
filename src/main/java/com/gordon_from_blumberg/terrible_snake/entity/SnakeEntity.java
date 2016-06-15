package com.gordon_from_blumberg.terrible_snake.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:47 012 12.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;
import com.gordon_from_blumberg.terrible_snake.entity.game.SnakePartEntity;

public interface SnakeEntity extends GameEntity {
    /**
     * Returns length of the snake
     *
     * @return Snake's length
     */
    int getLength();

    /**
     * Returns the snake head part
     *
     * @return The snake head part
     */
    SnakePartEntity getHead();
}
