package com.gordon_from_blumberg.service.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:14 020 20.06.16
 */

import com.gordon_from_blumberg.game.settings.Settings;
import com.gordon_from_blumberg.service.ServiceManager;
import com.gordon_from_blumberg.service.SettingsService;
import com.gordon_from_blumberg.utils.JsonUtils;

/**
 * Base implementation of the SettingsService
 */
public class SettingsServiceImpl implements SettingsService {
    private static final String SETTINGS_DIR = "settings/";
    private static final String SETTINGS_FILE_NAME = "settings.json";

    private Settings settings;

    public SettingsServiceImpl() {
        settings = readSettings();
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

    private Settings readSettings() {
        return JsonUtils.readFromJsonFile(getPath(), Settings.class);
    }

    private String getPath() {
        return ServiceManager.getPathService()
                .getPath(SETTINGS_DIR + SETTINGS_FILE_NAME).toString();
    }
}
