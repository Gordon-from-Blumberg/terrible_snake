package com.gordon_from_blumberg.lib.utils;

/**
 * Copyright (c) 2017 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 2:05 027 27.04.17
 */

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
}
