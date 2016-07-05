package com.gordon_from_blumberg.terrible_snake.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 2:22 003 03.07.16
 */

import com.gordon_from_blumberg.game.drawer.AbstractGameEntityDrawer;
import com.gordon_from_blumberg.game.drawer.GameEntityDrawerFactory;
import com.gordon_from_blumberg.game.entity.GameEntity;
import com.gordon_from_blumberg.utils.ReflectionUtils;

public class TerribleSnakeEntityDrawerFactory implements GameEntityDrawerFactory {
    private final String DRAWER_PACKAGE = getClass().getPackage().toString();

    private String type;

    public TerribleSnakeEntityDrawerFactory(String type) {
        this.type = type;
    }

    @Override
    public <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType, E entity) {
        System.out.println("DRAWER_PACKAGE = " + DRAWER_PACKAGE);
        String className = entityType.getName();
        System.out.println(String.format("ClassName of %s is %s", entityType, className));
        return ReflectionUtils.newInstanceOf(DRAWER_PACKAGE + "." + type + "." + className + "Drawer",
                new Object[] {entity});
    }

    public void setType(String type) {
        this.type = type;
    }
}
