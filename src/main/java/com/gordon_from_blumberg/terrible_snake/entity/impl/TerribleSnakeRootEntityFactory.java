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
import com.gordon_from_blumberg.terrible_snake.entity.stage.impl.TerribleSnakeStageImpl;
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
    private static final String STATE_CODE = "stateCode";

    private final Map<String, Class<? extends GameRootEntity>> STATE_ROOT_ENTITY_CLASS_MAP = new HashMap<>();

    //todo 1) use Reflection API instead map
    public TerribleSnakeRootEntityFactory() {
        STATE_ROOT_ENTITY_CLASS_MAP.put(MainMenu.STATE_KEY, MainMenuImpl.class);
        STATE_ROOT_ENTITY_CLASS_MAP.put(TerribleSnakeStage.STATE_KEY, TerribleSnakeStageImpl.class);
    }

    @Override
    public GameRootEntity create(String stateCode) {
        Pair<String, Map<String, String>> stateKeyArgsPair = parseStateCode(stateCode);
        System.out.println(String.format("parseStateCode has returned %s for stateCode %s", stateKeyArgsPair, stateCode));

        try {
            return STATE_ROOT_ENTITY_CLASS_MAP.get(stateKeyArgsPair.getKey()).getConstructor(Map.class).newInstance(stateKeyArgsPair.getValue());
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException(
                    String.format("Couldn't create the root entity for stateCode %s", stateCode),
                    e
            );
        }
    }

    //todo need test
    private Pair<String, Map<String, String>> parseStateCode(String stateCode) {
        final String keyPattern = "^[a-zA-Z]+";
        final String argsPattern = "([a-zA-Z]+)=([\\w]+)";
        final String generalPattern = String.format("%s(\\?%s(&%s)*)?$", keyPattern, argsPattern, argsPattern);

        if (!Pattern.matches(generalPattern, stateCode)) {
            throw new IllegalArgumentException(String.format("Illegal state code %s!", stateCode));
        }

        String key;
        Matcher keyMatcher = Pattern.compile(keyPattern).matcher(stateCode);
        keyMatcher.find();
        key = keyMatcher.group();

        Map<String, String> argsMap = new HashMap<>();
        argsMap.put(STATE_CODE, stateCode);
        Matcher argsMatcher = Pattern.compile(argsPattern).matcher(stateCode);
        while(argsMatcher.find()) {
            argsMap.put(argsMatcher.group(1), argsMatcher.group(2));
        }

        return new Pair<>(key, argsMap);
    }
}
