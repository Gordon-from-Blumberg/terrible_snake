package com.gordon_from_blumberg.lib.utils;

/**
 * Copyright (c) 2017 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 2:05 027 27.04.17
 */

import com.gordon_from_blumberg.lib.path.PathService;

import java.io.File;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Util methods for work with files
 */
public final class FileUtils {
    public static final String PATH_DELIMITER = "/";
    public static final String JAR_EXTENSION = ".jar";

    private FileUtils() {
    }

    /**
     * Runs the specified consumer for each file which the passed predicate returns true for
     *
     * @param file      File or directory. If it is directory, this method will be recursively invoked for each subfile
     * @param predicate Consumer will be accepted only if this predicate returns true
     * @param action    Action
     */
    public static void forEach(File file, Predicate<File> predicate, Consumer<File> action) {
        if (file.isFile() && predicate.test(file)) {
            action.accept(file);
        }

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files == null) {
                System.out.println(String.format("Warn! For directory %s listFiles returned null", file.getName()));
                return;
            }

            for (File subfile : files) {
                forEach(subfile, predicate, action);
            }
        }
    }

    public static boolean isJar(File file) {
        return file.getName().endsWith(JAR_EXTENSION);
    }

    /**
     * Converts the passed string path to the absolute form relative to the running dir
     * If it already is absolute, return it.
     *
     * @param path Path for absolutizing
     * @return Absolute path
     */
    public static String absolutizePath(String path) {
        return absolutizePath(path, PathService.getRunningDir());
    }

    /**
     * Converts the passed string path to the absolute form relative to the specified root path
     *
     * @param path     Path for absolutizing
     * @param rootPath The path will be absolutized relative to this root path. Should be absolute.
     * @return Absolute path
     */
    public static String absolutizePath(String path, String rootPath) {
        if (path.startsWith(rootPath)) return path;

        path = adjustDelimiters(path);

        if (!path.startsWith(PATH_DELIMITER)) {
            path = PATH_DELIMITER + path;
        }

        return rootPath + path;
    }

    /**
     * If the passed path contains the OS specific file delimiters, they will be replaced with slash symbol "/"
     *
     * @param path Path
     * @return Path with slash delimiters
     */
    public static String adjustDelimiters(String path) {
        if (!File.separator.equals(PATH_DELIMITER) && path.contains(File.separator)) {
            path = path.replace(File.separator, PATH_DELIMITER);
        }

        return path;
    }
}
