package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:22 013 13.06.16
 */

/**
 * Defines the root entity for each game state
 */
public interface GameRootEntity extends GameEntity {
    /**
     * This method must be called from the main loop and it must recursively call
     * the update method of all the children entities
     *
     * @return Must return false for quit from the game, true otherwise.
     */
    boolean updateRoot();
}
