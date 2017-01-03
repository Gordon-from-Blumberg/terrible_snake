package com.gordon_from_blumberg.lib.jar_loader;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:44 001 01.12.16
 */

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Loads classes from jar files
 */
public class JarLoader {
    private File baseDir;

    public JarLoader(File baseDir) {
        this.baseDir = baseDir;
    }

    public void addJarToClassLoader(String pathToJar) {
        try {

            //todo refactor
            URL jarURL = new URL(baseDir.getPath() + File.separator + pathToJar);

            URLClassLoader classLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            method.setAccessible(true);
            method.invoke(classLoader, jarURL);

            System.out.print(String.format("URL %s has been added to system class loader", jarURL));
//        } catch(MalformedURLException urlExc) {
//            System.err.print(String.format("Couldn't resolve URL for baseDir %s and path %s",
//                    baseDir, pathToJar));
//
//
        } catch(Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
