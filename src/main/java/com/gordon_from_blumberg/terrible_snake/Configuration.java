package com.gordon_from_blumberg.terrible_snake;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 17:04 012 12.06.16
 */

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Configuration constants
 */
public interface Configuration {
    int TICKS_PER_SECOND = 25;
    int MAX_FRAME_SKIP = 5;

    Path PROJECT_DIR = Paths.get("").toAbsolutePath();
}
