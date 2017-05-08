package com.gordon_from_blumberg.lib.path;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:07 025 25.06.16
 */

/**
 * Util methods for work with paths
 */
public final class PathUtils {
    private static final String runningDir;

    private PathUtils() {}

    static {
        runningDir = System.getProperty("runningDir");
    }

    /**
     * @return Path to the directory containing the jar file which the app was started from
     */
    public static String getRunningDir() {
        return runningDir;
    }

//    /**
//     * Returns the absolute path of the running directory
//     *
//     * @return Absolute path of the running directory as String
//     */
//    String getAbsoluteRunningDirPath();
//
//    /**
//     * Returns the path object for the specified path
//     *
//     * @param path Relative string path
//     * @return Path object
//     */
//    Path getPath(String path);
//
//    /**
//     * Returns the Path object appropriate to the resources directory
//     *
//     * @return Path of the resources directory
//     */
//    Path getResourceDir();
//
//    /**
//     * Returns the Path object appropriate to the particular resource directory
//     *
//     * @param resource Resource directory name
//     * @return Path of the particular resource directory
//     */
//    Path getResourceDir(String resource);
}
