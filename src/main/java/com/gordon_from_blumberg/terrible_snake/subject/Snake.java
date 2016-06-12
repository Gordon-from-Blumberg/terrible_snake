package com.gordon_from_blumberg.terrible_snake.subject;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:48 012 12.06.16
 */

import java.util.LinkedList;

public class Snake implements SnakeSubject {
    private LinkedList<SnakePartSubject> parts;

    @Override
    public void update() {

    }

    @Override
    public int getLength() {
        return parts.size();
    }

    @Override
    public SnakePartSubject getHead() {
        return parts.getFirst();
    }
}
