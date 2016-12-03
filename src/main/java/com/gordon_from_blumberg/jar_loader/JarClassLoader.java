package com.gordon_from_blumberg.jar_loader;

import java.io.File;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:54 003 03.12.16
 */

/**
 * Allows to load classes from jar files
 */
public class JarClassLoader extends URLClassLoader {
    private static final String JAR_PATH_DELIMITER = "!/";
    private static final String PATH_DELIMITER = "/";
    private static final String JAR_EXTENSION = ".jar";

    private static String runningDir;

    static {
        findRunningDir();
    }

    public JarClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
        System.out.println("JarClassLoader is created");
    }

    public static String getRunningDir() {
        return runningDir;
    }

    public void findJars() {
        findAllJarUrls().forEach(this::addURL);
    }

    private static void findRunningDir() {
        runningDir = clip(
                clip(
                        JarClassLoader.class.getResource("").getPath(),
                        JAR_PATH_DELIMITER
                ),
                PATH_DELIMITER
        );
        System.out.println("Running dir = " + runningDir);
    }

    private static String clip(String str, String delimiter) {
        return str.substring(0, str.lastIndexOf(delimiter));
    }

    private List<URL> findAllJarUrls() {
        System.out.println("findAllJarUrls start");
        final List<URL> urlList = new ArrayList<>();
        try {
            addJarToList(new File(new URI(runningDir)), urlList); //new File(runningDir) leads to initialization exception
            System.out.println("Found jars: " + urlList.size());
        } catch(URISyntaxException e) {
            e.printStackTrace();
        }
        return urlList;
    }

    //todo refactor exception catching
    private void addJarToList(File file, List<URL> urlList) {
        if (file.isFile() && isJar(file)) {
            try {
                urlList.add(file.toURI().toURL());
                System.out.println("Add jar file to JarClassLoader: " + file.getName());
            } catch(MalformedURLException e) {
                System.err.println("Invalid file " + file.getAbsolutePath());
            }
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            try {
                for (File subfile : files) {
                    addJarToList(subfile, urlList);
                }
            } catch(NullPointerException e) {
                System.err.println("Invalid file " + file.getAbsolutePath());
            }
        }
    }

    private boolean isJar(File file) {
        return file.getName().endsWith(JAR_EXTENSION);
    }
}
