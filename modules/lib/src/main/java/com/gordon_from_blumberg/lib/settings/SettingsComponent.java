package com.gordon_from_blumberg.lib.settings;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:09 007 07.06.16
 */

/**
 * Service for work with settings
 * @param <T> Type of the settings
 */
public interface SettingsComponent<T> {
    /**
     * @return Current settings
     */
    T getSettings();

    /**
     * Updates the settings file
     */
    void updateSettings();
}
