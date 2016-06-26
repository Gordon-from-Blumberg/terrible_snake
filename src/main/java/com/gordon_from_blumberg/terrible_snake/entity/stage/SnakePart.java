package com.gordon_from_blumberg.terrible_snake.entity.stage;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:42 012 12.06.16
 */


/**
 * Defines one part of the snake
 */
public interface SnakePart extends GridElement {
    /**
     * Moves this snake part to the specified grid cell
     *
     * @param gridCell Destination grid cell
     */
    void moveTo(Grid.GridCell gridCell);
}
