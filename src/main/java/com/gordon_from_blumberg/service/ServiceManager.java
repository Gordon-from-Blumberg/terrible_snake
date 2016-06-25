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
import com.gordon_from_blumberg.service.impl.PathServiceImpl;
import com.gordon_from_blumberg.service.impl.SettingsServiceImpl;

/**
 * Keeps the instances of services
 * and implements the static methods for the access to them
 */
public class ServiceManager {
    //todo Use reflection API and dependency injection
    private static PathService pathService = new PathServiceImpl();
    private static DictionaryService dictionaryService = new DictionaryServiceImpl();
    private static SettingsService settingsService = new SettingsServiceImpl();

    public static PathService getPathService() {
        return pathService;
    }

    public static DictionaryService getDictionaryService() {
        return dictionaryService;
    }

    public static SettingsService getSettingsService() {
        return settingsService;
    }
}
