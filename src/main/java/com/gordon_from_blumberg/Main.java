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
import com.gordon_from_blumberg.terrible_snake.TerribleSnake;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static File runningDir;

    public static void main(String args[]) {
        Map<String, String> argsMap = getArgsMap(args);

        System.out.println("Property runningDir = " + System.getProperty("runningDir"));
        System.out.println("Property java.system.class.loader = " + System.getProperty("java.system.class.loader"));
        System.out.println("Property classpath = " + System.getProperty("classpath"));

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

    private static Map<String, String> getArgsMap(String[] args) {
        Map<String, String> argsMap = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-") && i + 1 < args.length) {
                argsMap.put(args[i].substring(1), args[++i]);
            } else {
                System.out.println(String.format("Ignored argument: %s", args[i]));
            }
        }

        return argsMap;
    }

    private static void init() {
        try {
            findRunningDir();

            JarLoader jarLoader = new JarLoader(runningDir);

            jarLoader.addJarToClassLoader("lib/lib.jar");

        } catch(Throwable e) {
            System.out.print(e);
        }
    }

    private static void findRunningDir() {
        String pathToMainClass = Main.class.getResource("").getPath();
        String pathToJar = pathToMainClass.substring(0, pathToMainClass.indexOf("!/"));
        runningDir = new File(pathToJar).getParentFile();
        System.out.print(String.format("Running dir = %s", runningDir));
        System.out.println();
    }
}
