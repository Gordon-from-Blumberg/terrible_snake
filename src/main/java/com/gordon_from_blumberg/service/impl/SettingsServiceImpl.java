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
import com.gordon_from_blumberg.service.PathService;
import com.gordon_from_blumberg.service.ServiceHolder;
import com.gordon_from_blumberg.service.SettingsService;
import com.gordon_from_blumberg.service.annotation.Inject;
import com.gordon_from_blumberg.service.annotation.Injectable;
import com.gordon_from_blumberg.utils.JsonUtils;

/**
 * Base implementation of the SettingsService
 */
@Injectable("settingsService")
public class SettingsServiceImpl implements SettingsService {
    private static final String SETTINGS_DIR = "settings/";
    private static final String SETTINGS_FILE_NAME = "settings.json";

    @Inject
    private PathService pathService;

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
        return ServiceHolder.getService(PathService.class)
                .getResourceDir(SETTINGS_DIR + SETTINGS_FILE_NAME).toString();
    }
}
