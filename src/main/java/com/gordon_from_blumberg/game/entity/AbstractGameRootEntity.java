package com.gordon_from_blumberg.game.entity;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:17 027 27.06.16
 */

import javax.swing.*;
import java.util.Map;

/**
 * Abstract root entity
 */
public abstract class AbstractGameRootEntity implements GameRootEntity {
    private String stateCode;
    protected JApplet applet;

    /**
     * Creates applet
     */
    public AbstractGameRootEntity(Map<String, String> args) {
        applet = new JApplet();
        stateCode = args.get("stateCode");
    }

    @Override
    public void updateFrame(JFrame frame) {
        frame.setContentPane(applet);
    }

    @Override
    public String getStateCode() {
        return stateCode;
    }
}
