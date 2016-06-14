package com.gordon_from_blumberg.terrible_snake.subject.game.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:36 015 15.06.16
 */

import com.gordon_from_blumberg.game.subject.GameRootSubjectBuilder;

/**
 * The builder of the TerribleSnake stages
 */
public class TerribleSnakeStageBuilder implements GameRootSubjectBuilder<TerribleSnakeStage> {
    @Override
    public TerribleSnakeStage build() {
        return new TerribleSnakeStage();
    }
}
