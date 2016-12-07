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
import com.gordon_from_blumberg.jar_loader.JarClassLoader;
import com.gordon_from_blumberg.service.ServiceHolder;
import com.gordon_from_blumberg.terrible_snake.TerribleSnake;

public final class Main {

    public static void main(String args[]) {
        System.out.println("Property java.system.class.loader = " + System.getProperty("java.system.class.loader"));

        init();

        Game game = new TerribleSnake();

        final int SKIP_TICKS = 1000 / game.getTicksPerSecond();
        final int MAX_FRAME_SKIP = game.getMaxFrameSkip();

        long nextGameTick = System.currentTimeMillis();
        long prevGameTick = nextGameTick - SKIP_TICKS;

        try {
            game.init();

            while(game.isRunning()) {
                int skippedFrames = 0;

                while(System.currentTimeMillis() > nextGameTick && skippedFrames < MAX_FRAME_SKIP) {
                    game.updateGame();

                    prevGameTick = nextGameTick;
                    nextGameTick += SKIP_TICKS;
                    skippedFrames++;
                }

                game.renderGame(interpolate(prevGameTick, SKIP_TICKS));
            }
        } catch(Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static float interpolate(long prevGameTick, int skipTicks) {
        float currentTick = (float) (System.currentTimeMillis() - prevGameTick);
        return currentTick / skipTicks;
    }

    private static void init() {
        try {

            initJarClassLoader();
            initServiceHolder();

            System.out.println();

        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    private static void initJarClassLoader() {
        JarClassLoader jarClassLoader = (JarClassLoader) ClassLoader.getSystemClassLoader();
        jarClassLoader.findJars();
    }

    private static void initServiceHolder() {
        ServiceHolder.init();
    }
}
