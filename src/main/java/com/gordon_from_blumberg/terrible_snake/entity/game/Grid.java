package com.gordon_from_blumberg.terrible_snake.entity.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:50 017 17.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

/**
 * Defines the grid entity
 */
public interface Grid extends GameEntity {

    /**
     * Returns the grid cell by specified coords
     *
     * @param x X coordinate
     * @param y Y coordinate
     * @return The grid cell
     * @throws RuntimeException will be thrown if specified coords are out of grid
     */
    GridCell getCell(int x, int y);

    /**
     * Defines the cell of the grid
     */
    interface GridCell {
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

        /**
         * Checks is there on this cell a grid element
         *
         * @return True if there are no grid element
         */
        boolean isFree();

        /**
         * @return Grid element on this cell or null
         */
        GridElement getEntity();

        /**
         * Sets new grid element to this grid cell.
         * Must be called only from GridElement.setGridCell!
         *
         * @param entity The new entity on this grid cell
         */
        void setEntity(GridElement entity);
    }
}
