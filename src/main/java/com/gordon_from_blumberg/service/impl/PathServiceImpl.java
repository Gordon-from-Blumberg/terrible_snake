package com.gordon_from_blumberg.service.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:16 025 25.06.16
 */

import com.gordon_from_blumberg.jar_loader.JarClassLoader;
import com.gordon_from_blumberg.service.PathService;
import com.gordon_from_blumberg.utils.StringUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Base implementation of the PathService
 */
public class PathServiceImpl implements PathService {
    private Path runningDir;

    public PathServiceImpl() {
        runningDir = getRunningDir();
    }

    @Override
    public Path getRunningDirPath() {
        return runningDir;
    }

    @Override
    public String getAbsoluteRunningDirPath() {
        return runningDir.toAbsolutePath().toString();
    }

    @Override
    public Path getPath(String path) {
        return runningDir.resolve(path);
    }

    @Override
    public Path getResourceDir() {
        return runningDir.resolve(RESOURCES_DIR);
    }

    @Override
    public Path getResourceDir(String resource) {
        return getResourceDir().resolve(resource);
    }

    private static Path getRunningDir() {
        String runningDirProperty = JarClassLoader.getRunningDir();
        return Paths.get(StringUtils.isBlank(runningDirProperty) ?
                "" : runningDirProperty);
    }
}
