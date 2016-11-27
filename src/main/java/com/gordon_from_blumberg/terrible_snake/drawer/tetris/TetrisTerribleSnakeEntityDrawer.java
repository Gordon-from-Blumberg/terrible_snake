package com.gordon_from_blumberg.terrible_snake.drawer.tetris;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:43 026 26.11.16
 */

import com.gordon_from_blumberg.game.drawer.EntityDrawer;
import com.gordon_from_blumberg.terrible_snake.drawer.TerribleSnakeEntityDrawer;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuContainer;
import com.gordon_from_blumberg.terrible_snake.entity.stage.*;

@EntityDrawer(name = TetrisTerribleSnakeEntityDrawer.NAME)
public class TetrisTerribleSnakeEntityDrawer implements TerribleSnakeEntityDrawer {
    protected static final String NAME = "tetris";

    @Override
    public void drawMenuContainer(MenuContainer entity, float interpolation) {

    }

    @Override
    public void drawStage(TerribleSnakeStage entity, float interpolation) {

    }

    @Override
    public void drawGrid(Grid entity, float interpolation) {

    }

    @Override
    public void drawSnake(Snake entity, float interpolation) {

    }

    @Override
    public void drawFood(Food entity, float interpolation) {

    }

    @Override
    public void drawObstacle(Obstacle entity, float interpolation) {

    }

    @Override
    public String getName() {
        return NAME;
    }
}
