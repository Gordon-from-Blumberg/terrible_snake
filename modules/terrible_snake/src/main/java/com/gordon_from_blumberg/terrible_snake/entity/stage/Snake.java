package com.gordon_from_blumberg.terrible_snake.entity.stage;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:47 012 12.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

/**
 * Snake
 */
public interface Snake extends GameEntity {
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
    SnakePart getHead();
}
