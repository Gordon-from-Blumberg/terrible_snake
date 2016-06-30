package com.gordon_from_blumberg.terrible_snake.entity.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:54 026 26.06.16
 */

import com.gordon_from_blumberg.game.entity.GameRootEntity;
import com.gordon_from_blumberg.game.entity.GameRootEntityFactory;
import com.gordon_from_blumberg.terrible_snake.entity.menu.MainMenu;
import com.gordon_from_blumberg.terrible_snake.entity.menu.impl.MainMenuImpl;
import com.gordon_from_blumberg.terrible_snake.entity.stage.TerribleSnakeStage;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creator of the Terrible Snake root entities
 */
public class TerribleSnakeRootEntityFactory
        implements GameRootEntityFactory {

    private final Map<String, Class<? extends GameRootEntity>> STATE_ROOT_ENTITY_CLASS_MAP = new HashMap<>();

    //todo 1) remove the string magic constants
    //todo 2) use Reflection API instead map
    public TerribleSnakeRootEntityFactory() {
        STATE_ROOT_ENTITY_CLASS_MAP.put("menu", MainMenu.class);
        STATE_ROOT_ENTITY_CLASS_MAP.put("stage", TerribleSnakeStage.class);
    }

    @Override
    public GameRootEntity create(String stateCode) {
        Pair<String, Map<String, String>> stateKeyArgsPair = parseStateCode(stateCode);
        //return STATE_ROOT_ENTITY_CLASS_MAP.get(stateKeyArgsPair.getKey()).newInstance(stateKeyArgsPair.getValue());
        return new MainMenuImpl();
    }

    private Pair<String, Map<String, String>> parseStateCode(String stateCode) {
        String argsPattern = "[a-zA-Z]+=[\\w]+";
        Pattern stateCodeRegex = Pattern.compile(String.format("^([a-zA-Z]+)(\\?(%s)(&(%s))*)?$", argsPattern, argsPattern));
        Matcher matcher = stateCodeRegex.matcher(stateCode);
        matcher.find();

        return new Pair<>("", new HashMap<>());
    }
}
