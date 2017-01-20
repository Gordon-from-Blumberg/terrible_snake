package com.gordon_from_blumberg.jar_loader;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:44 001 01.12.16
 */

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads classes from jar files
 */
public final class JarLoader {
    private static final String JAR_PATH_DELIMITER = "!/";
    private static final String PATH_DELIMITER = "/";
    private static final String JAR_EXTENSION = ".jar";
    private static final String URL_PATH_PREFIX = "file:/";

    private static String runningDir;

    private JarLoader() {
    }

    public static String getRunningDir() {
        return runningDir;
    }

    public static void addJarsToClassLoader(URLClassLoader classLoader) {
        findRunningDir();

        try {
            List<URL> urlList = new ArrayList<>();

            addJarToList(new File(runningDir), urlList);

            System.out.println(String.format("Found %s jars", urlList.size()));

            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);

            urlList.forEach(url -> {
                try {
                    method.invoke(classLoader, url);
                    System.out.println(String.format("URL %s has been added to system class loader", url));
                } catch(IllegalAccessException | InvocationTargetException e) {
                    System.out.println(String.format("Caught exception %s for url %s", e, url));
                }
            });

        } catch(NoSuchMethodException e) {
            throw new RuntimeException(String.format("Method addURL is not found in classLoader %s", classLoader), e);
        }
    }

    private static void addJarToList(File file, List<URL> urlList) {
        if (file.isFile() && isJar(file)) {
            try {
                urlList.add(file.toURI().toURL());
                System.out.println("Add jar file to JarLoader: " + file.getName());
            } catch(MalformedURLException e) {
                System.err.println("Invalid file " + file.getAbsolutePath());
            }
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files == null) {
                System.out.println(String.format("Warn! For file %s listFiles returned null", file.getName()));
            }

            for (File subfile : files) {
                addJarToList(subfile, urlList);
            }
        }
    }

    private static void findRunningDir() {
        String path = JarLoader.class.getResource("").getPath();
        path = path.startsWith(URL_PATH_PREFIX) ?
                path.substring(URL_PATH_PREFIX.length()) :
                path;

        runningDir = clip(clip(path, JAR_PATH_DELIMITER), PATH_DELIMITER);

        System.out.println("Running dir = " + runningDir);
    }

    private static String clip(String str, String delimiter) {
        return str.substring(0, str.lastIndexOf(delimiter));
    }

    private static boolean isJar(File file) {
        return file.getName().endsWith(JAR_EXTENSION);
    }
}
