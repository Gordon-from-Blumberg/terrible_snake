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
import com.gordon_from_blumberg.terrible_snake.Configuration;
import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawerFactory;
import com.gordon_from_blumberg.terrible_snake.entity.stage.TerribleSnakeStage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TerribleSnakeStageImpl
        extends AbstractGameRootEntity
        implements TerribleSnakeStage {

    private List<GameEntity> children = new ArrayList<>();

    public TerribleSnakeStageImpl(Map<String, String> args) {
        super(args);
        createDrawers(new TerribleSnakeEntityDrawerFactory(Configuration.DEFAULT_DRAWER_TYPE));
    }

    @Override
    public String updateRoot() {
        children.forEach(GameEntity::update);
        return getStateCode();
    }

    @Override
    public void render(float interpolation) {
        children.forEach(child -> child.render(interpolation));
    }

    @Override
    public void createDrawers(GameEntityDrawerFactory drawerFactory) {
        children.forEach(gameEntity -> gameEntity.createDrawer(drawerFactory, applet));
    }
}
