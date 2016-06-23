package com.gordon_from_blumberg.game.settings;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:04 007 07.06.16
 */

/**
 * Graphic settings
 */
public class GraphicSettings {
    /**
     * Width of the game window in pixels
     */
    Integer screenWidth;
    /**
     * Height of the game window in pixels
     */
    Integer screenHeight;

    /**
     * True, if in full screen mode
     */
    Boolean fullScreen;

    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Boolean getFullScreen() {
        return fullScreen;
    }

    public void setFullScreen(Boolean fullScreen) {
        this.fullScreen = fullScreen;
    }
}