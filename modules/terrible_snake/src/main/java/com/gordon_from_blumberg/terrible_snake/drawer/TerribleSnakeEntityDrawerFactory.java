package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:54 027 27.11.16
 */

import com.gordon_from_blumberg.game.drawer.EntityDrawer;
import com.gordon_from_blumberg.lib.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates instances implementing <code>TerribleSnakeEntityDrawer</code>
 */
public class TerribleSnakeEntityDrawerFactory {
    private static final String DRAWER_PACKAGE = TerribleSnakeEntityDrawerFactory.class.getPackage().getName();
    private static final Map<String, Class<? extends TerribleSnakeEntityDrawer>> drawers = new HashMap<>();

    private static boolean initiliazed = false;

    /**
     * Creates the instance of the TerribleSnakeEntityDrawer appropriate to the specified name
     *
     * @param name Name of the TerribleSnakeEntityDrawer instance
     * @return Instance of TerribleSnakeEntityDrawer
     */
    public static TerribleSnakeEntityDrawer createDrawer(String name) {
        if (!initiliazed) {
            init();
        }

        Class<? extends TerribleSnakeEntityDrawer> clazz = drawers.get(name);

        if (clazz == null) {
            throw new IllegalArgumentException(String.format("Drawer for name %s is not registered!", name));
        }

        return ReflectionUtils.newInstanceOf(clazz);
    }

    @SuppressWarnings("unchecked")
    private static void addDrawer(Class<?> clazz) {
        if (!clazz.isAssignableFrom(TerribleSnakeEntityDrawer.class)) {
            System.out.print(String.format("Error! The passed %s does not implement the %s",
                    clazz, TerribleSnakeEntityDrawer.class));

            return;
        }

        Class<? extends TerribleSnakeEntityDrawer> drawerType = (Class<? extends TerribleSnakeEntityDrawer>) clazz;
        String name = getName(drawerType);
        drawers.put(name, drawerType);
        System.out.print(String.format("The %s has been registered as %s",
                drawerType, name));
    }

    private static void init() {
        System.out.print(String.format("Drawer package = %s", DRAWER_PACKAGE));


    }

    private static String getName(Class<? extends TerribleSnakeEntityDrawer> clazz) {
        EntityDrawer entityDrawerAnnotation = clazz.getAnnotation(EntityDrawer.class);
        return entityDrawerAnnotation.name();
    }
}
