package com.gordon_from_blumberg.terrible_snake.entity.game.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:48 012 12.06.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.SnakeEntity;
import com.gordon_from_blumberg.terrible_snake.entity.game.SnakePartEntity;

import java.util.LinkedList;

public class Snake implements SnakeEntity {
    private LinkedList<SnakePartEntity> parts;

    @Override
    public void update() {

    }

    @Override
    public int getLength() {
        return parts.size();
    }

    @Override
    public SnakePartEntity getHead() {
        return parts.getFirst();
    }
}
