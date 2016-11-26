package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:00 026 26.11.16
 */

/**
 * Holds the current instance of entity drawer
 */
public class TerribleSnakeEntityDrawerHolder {
    private static TerribleSnakeEntityDrawer drawer;

    /**
     * @return Current instance of entity drawer
     */
    public static TerribleSnakeEntityDrawer getDrawer() {
        return drawer;
    }

    /**
     * @param drawer New instance of entity drawer
     */
    public static void setDrawer(TerribleSnakeEntityDrawer drawer) {
        TerribleSnakeEntityDrawerHolder.drawer = drawer;
    }
}
