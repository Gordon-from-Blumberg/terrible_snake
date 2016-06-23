package com.gordon_from_blumberg.game.settings;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:03 007 07.06.16
 */

/**
 * Main settings class
 */
public class Settings {
    GameSettings gameSettings;

    GraphicSettings graphicSettings;

    SoundSettings soundSettings;

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public GraphicSettings getGraphicSettings() {
        return graphicSettings;
    }

    public void setGraphicSettings(GraphicSettings graphicSettings) {
        this.graphicSettings = graphicSettings;
    }

    public SoundSettings getSoundSettings() {
        return soundSettings;
    }

    public void setSoundSettings(SoundSettings soundSettings) {
        this.soundSettings = soundSettings;
    }
}