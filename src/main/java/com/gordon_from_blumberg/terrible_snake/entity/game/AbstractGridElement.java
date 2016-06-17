package com.gordon_from_blumberg.terrible_snake.entity.game;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:44 014 14.06.16
 */

abstract public class AbstractGridElement implements GridElement {
    private Grid.GridCell gridCell;

    public AbstractGridElement(Grid.GridCell gridCell) {
        this.gridCell = gridCell;
    }

    @Override
    public int getX() {
        return gridCell.getX();
    }

    @Override
    public int getY() {
        return gridCell.getY();
    }

    @Override
    public Grid.GridCell getGridCell() {
        return gridCell;
    }

    protected void setGridCell(Grid.GridCell gridCell) {
        this.gridCell = gridCell;
        gridCell.setEntity(this);
    }
}
