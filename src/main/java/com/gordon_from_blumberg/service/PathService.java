package com.gordon_from_blumberg.service;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:07 025 25.06.16
 */

import java.nio.file.Path;

/**
 * Service for the path processing
 */
public interface PathService {
    /**
     * Returns the Path object appropriate to the running directory
     *
     * @return Path of the running directory
     */
    Path getRunningDirPath();

    /**
     * Returns the absolute path of the running directory
     *
     * @return Absolute path of the running directory as String
     */
    String getAbsoluteRunningDirPath();

    /**
     * Returns the path object for the specified path
     *
     * @param path Relative string path
     * @return Path object
     */
    Path getPath(String path);
}
