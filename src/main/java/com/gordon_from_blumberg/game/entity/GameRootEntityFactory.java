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
 * Defines the creator object for the root entities creating
 */
public interface GameRootEntityFactory {
    /**
     * Resolves the passed code of the game state and creates appropriate root entity
     *
     * @param stateCode The code for identification of the required root entity
     * @return Created root entity object
     * @throws GameRootEntityFactory.UnknownStateException If the passed stateCode can't be resolved
     */
    GameRootEntity create(String stateCode);

    class UnknownStateException extends IllegalArgumentException {
        public UnknownStateException(String message) {
            super(message);
        }
    }
}
