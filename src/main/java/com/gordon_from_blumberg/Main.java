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
import com.gordon_from_blumberg.lib.jar_loader.JarClassLoader;

public final class Main {

    public static void main(String args[]) {
        System.out.println("Property java.system.class.loader = " + System.getProperty("java.system.class.loader"));

        init();

        Game game = new Game();

        try {

            game.run();

        } catch(Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void init() {
        try {

            initJarClassLoader();

        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    private static void initJarClassLoader() {
        JarClassLoader jarClassLoader = (JarClassLoader) ClassLoader.getSystemClassLoader();
        jarClassLoader.findJars();
    }
}
