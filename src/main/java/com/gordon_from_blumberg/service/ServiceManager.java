package com.gordon_from_blumberg.service;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:57 025 25.06.16
 */

import com.gordon_from_blumberg.service.impl.DictionaryServiceImpl;
import com.gordon_from_blumberg.service.impl.GroovyServiceImpl;
import com.gordon_from_blumberg.service.impl.PathServiceImpl;
import com.gordon_from_blumberg.service.impl.SettingsServiceImpl;

/**
 * Keeps the instances of services
 * and implements the static methods for the access to them
 */
public class ServiceManager {
    //todo Use reflection API and dependency injection
    private static final PathService pathService = new PathServiceImpl();
    private static final DictionaryService dictionaryService = new DictionaryServiceImpl();
    private static final SettingsService settingsService = new SettingsServiceImpl();
    private static final GroovyService groovyService = new GroovyServiceImpl();

    public static PathService getPathService() {
        return pathService;
    }

    public static DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    public static SettingsService getSettingsService() {
        return settingsService;
    }

    public static GroovyService getGroovyService() {
        return groovyService;
    }
}
