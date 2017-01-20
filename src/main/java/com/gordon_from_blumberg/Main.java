package com.gordon_from_blumberg;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 16:06 011 11.06.16
 */

import com.gordon_from_blumberg.game.Game;
import com.gordon_from_blumberg.jar_loader.JarLoader;

import java.net.URLClassLoader;

public final class Main {

    public static void main(String args[]) {
        try {

            init();

            Game game = new Game();

            game.run();

        } catch(Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void init() {
        try {

            initJarLoader();

        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    private static void initJarLoader() {
        URLClassLoader classLoader = (URLClassLoader) Main.class.getClassLoader();
        JarLoader.addJarsToClassLoader(classLoader);
    }
}
