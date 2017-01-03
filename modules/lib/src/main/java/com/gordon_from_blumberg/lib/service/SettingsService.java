package com.gordon_from_blumberg.lib.service;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:09 007 07.06.16
 */

import com.gordon_from_blumberg.game.settings.Settings;

/**
 * Service for work with settings
 */
public interface SettingsService {
    /**
     * @return Current settings
     */
    Settings getSettings();

}
