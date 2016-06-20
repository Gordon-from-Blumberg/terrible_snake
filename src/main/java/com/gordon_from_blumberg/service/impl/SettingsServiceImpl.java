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
import com.gordon_from_blumberg.service.SettingsService;
import com.gordon_from_blumberg.terrible_snake.Configuration;
import com.gordon_from_blumberg.utils.JsonUtils;

public class SettingsServiceImpl implements SettingsService {
    private static final String SETTINGS_DIR = "src/main/settings/";
    private static final String SETTINGS_FILE_NAME = "settings.json";

    private Settings settings;

    public SettingsServiceImpl() {
        readSettings();
    }

    @Override
    public Settings getSettings() {
        if (settings == null) {
            readSettings();
        }

        return settings;
    }

    private void readSettings() {
        settings = JsonUtils.readFromJsonFile(getPath(), Settings.class);
    }

    private String getPath() {
        return Configuration.PROJECT_DIR.resolve(SETTINGS_DIR + SETTINGS_FILE_NAME).toString();
    }
}
