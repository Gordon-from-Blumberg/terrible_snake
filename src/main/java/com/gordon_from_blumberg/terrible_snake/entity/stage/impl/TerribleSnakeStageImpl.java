package com.gordon_from_blumberg.terrible_snake.entity.stage.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:42 013 13.06.16
 */

import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.game.entity.AbstractGameRootEntity;
import com.gordon_from_blumberg.game.entity.GameEntity;
import com.gordon_from_blumberg.terrible_snake.entity.stage.TerribleSnakeStage;

import java.util.List;

public class TerribleSnakeStageImpl
        extends AbstractGameRootEntity
        implements TerribleSnakeStage {

    private List<GameEntity> children;

    @Override
    public String updateRoot() {
        return "";
    }

    @Override
    public void render(float interpolation) {

    }

    @Override
    public void createDrawers(GameEntityDrawerFactory drawerFactory) {
        children.stream()
                .forEach(gameEntity -> gameEntity.createDrawer(drawerFactory, applet));
    }
}
