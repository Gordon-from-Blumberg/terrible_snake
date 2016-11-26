package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:01 026 26.11.16
 */

import com.gordon_from_blumberg.terrible_snake.entity.menu.MenuContainer;
import com.gordon_from_blumberg.terrible_snake.entity.stage.*;

/**
 * Defines render methods for each entity
 */
public interface TerribleSnakeEntityDrawer {
    void drawMenuContainer(MenuContainer entity, float interpolation);

    void drawStage(TerribleSnakeStage entity, float interpolation);

    void drawGrid(Grid entity, float interpolation);

    void drawSnake(Snake entity, float interpolation);

    void drawFood(Food entity, float interpolation);

    void drawObstacle(Obstacle entity, float interpolation);
}
