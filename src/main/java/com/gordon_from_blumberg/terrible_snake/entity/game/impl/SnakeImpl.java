package com.gordon_from_blumberg.terrible_snake.entity.game.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:48 012 12.06.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.game.Snake;
import com.gordon_from_blumberg.terrible_snake.entity.game.SnakePart;

import java.util.LinkedList;

public class SnakeImpl implements Snake {
    private LinkedList<SnakePart> parts;

    private float speed;
    private int direction;

    @Override
    public int getLength() {
        return parts.size();
    }

    @Override
    public SnakePart getHead() {
        return parts.getFirst();
    }

    @Override
    public void update() {

    }

    @Override
    public void render(float interpolation) {

    }
}
