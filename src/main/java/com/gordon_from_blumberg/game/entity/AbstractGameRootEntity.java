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

/**
 * Abstract root entity
 */
public abstract class AbstractGameRootEntity implements GameRootEntity {
    protected JApplet applet;

    /**
     * Creates applet
     */
    public AbstractGameRootEntity() {
        applet = new JApplet();
    }

    @Override
    public void updateFrame(JFrame frame) {
        frame.setContentPane(applet);
    }
}
