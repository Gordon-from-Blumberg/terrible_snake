package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:26 015 15.06.16
 */

/**
 * Defines the builder object for the root entities
 */
public interface GameRootEntityBuilder<S extends GameRootEntity> {
    S build();
}
