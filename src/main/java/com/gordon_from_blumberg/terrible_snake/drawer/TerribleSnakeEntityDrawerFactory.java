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
import javafx.util.Pair;

public class TerribleSnakeEntityDrawerFactory implements GameEntityDrawerFactory {
    private final String ENTITY_PACKAGE_NAME = "entity";
    private final String DRAWER_SUFFIX = "Drawer";
    private final String DRAWER_PACKAGE = getClass().getPackage().getName();

    private String type;

    public TerribleSnakeEntityDrawerFactory(String type) {
        this.type = type;
    }

    @Override
    public <E extends GameEntity> AbstractGameEntityDrawer<E> createDrawerFor(Class<E> entityType, E entity) {
        System.out.println("DRAWER_PACKAGE = " + DRAWER_PACKAGE);
        String className = ReflectionUtils.getRelativeClassPath(entityType, ENTITY_PACKAGE_NAME);
        System.out.println(String.format("ClassName of %s is %s", entityType, className));
        return ReflectionUtils.newInstanceOf(composeDrawerClassName(className),
                new Pair<>(entityType, entity));
    }

    public void setType(String type) {
        this.type = type;
    }

    private String composeDrawerClassName(String entityClassName) {
        return String.join(ReflectionUtils.DELIMITER, new String[] {
                DRAWER_PACKAGE,
                type,
                entityClassName + DRAWER_SUFFIX
        });
    }
}
