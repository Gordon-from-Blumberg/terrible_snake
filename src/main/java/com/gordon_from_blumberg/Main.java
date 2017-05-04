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
import com.gordon_from_blumberg.lib.class_finder.ClassFinder;
import com.gordon_from_blumberg.lib.path.PathService;

import java.net.URLClassLoader;

public final class Main {
    private static final String SYS_PROPERTIES_DELIMITER = "=";

    public static void main(String[] args) {
        try {

            init(args);

            ClassFinder classFinder = new ClassFinder(PathService.getRunningDir() + "/apps");

            Game game = new Game();

            game.run();

        } catch(Throwable e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void init(String[] args) {
        try {

            setSystemProperties(args);

            initJarLoader();

        } catch(Throwable e) {
            e.printStackTrace();
        }
    }

    private static void setSystemProperties(String[] args) {
        for (String arg : args) {
            if (arg.contains(SYS_PROPERTIES_DELIMITER)) {
                String[] propertyAndValue = arg.split(SYS_PROPERTIES_DELIMITER);
                System.out.println(String.format("Set system property %s = %s", propertyAndValue[0], propertyAndValue[1]));
                System.setProperty(propertyAndValue[0], propertyAndValue[1]);
            }
        }
    }

    private static void initJarLoader() {
        URLClassLoader classLoader = (URLClassLoader) Main.class.getClassLoader();
        JarLoader.addJarsToClassLoader(classLoader);
    }
}
