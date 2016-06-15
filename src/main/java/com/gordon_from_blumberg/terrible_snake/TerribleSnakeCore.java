package com.gordon_from_blumberg.terrible_snake;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 17:14 012 12.06.16
 */

import com.gordon_from_blumberg.game.GameCore;
import com.gordon_from_blumberg.game.entity.GameRootEntity;

public class TerribleSnakeCore implements GameCore {
    private GameRootEntity rootEntity;
    private State currentState;

    @Override
    public boolean update() {
        rootEntity.update();
        return false;
    }

    private enum State {
        MAIN_MENU,
        RUNNING_GAME;
    }
}