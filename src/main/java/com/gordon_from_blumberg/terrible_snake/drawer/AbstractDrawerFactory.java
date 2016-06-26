package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:31 026 26.06.16
 */

import com.gordon_from_blumberg.terrible_snake.drawer.menu.MainMenuDrawer;
import com.gordon_from_blumberg.terrible_snake.drawer.stage.TerribleSnakeStageDrawer;

/**
 * Abstract factory pattern. Creates the drawer instances for entities
 */
public abstract class AbstractDrawerFactory {
    public abstract MainMenuDrawer createMainMenuDrawer();

    public abstract TerribleSnakeStageDrawer createTerribleSnakeStageDrawer();
}
