package com.gordon_from_blumberg.lib.groovy;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 21:56 002 02.07.16
 */

import java.util.Map;

/**
 * Service for the groovy scripts running
 */
public interface GroovyService {
    /**
     * Executes the groovy script and returns its result
     *
     * @param scriptPath Path to the groovy file
     * @param params     Map of the parameters for the script
     * @param <T>        Expected type of the result
     * @return Result of the script execution
     */
    <T> T execute(String scriptPath, Map<String, Object> params);
}
