package com.gordon_from_blumberg.terrible_snake.subject;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:41 014 14.06.16
 */

import com.gordon_from_blumberg.game.subject.GameSubject;

public interface GridSubject extends GameSubject {
    /**
     * @return X coordinate of the subject on the grid
     */
    int getX();

    /**
     * Sets new X coordinate of the subject on the grid
     * @param x New value of X coordinate
     */
    void setX(int x);

    /**
     * @return Y coordinate of the subject on the grid
     */
    int getY();

    /**
     * Sets new Y coordinate of the subject on the grid
     * @param y New value of Y coordinate
     */
    void setY(int y);
}
