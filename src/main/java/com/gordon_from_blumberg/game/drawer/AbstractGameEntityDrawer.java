package com.gordon_from_blumberg.game.drawer;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:34 027 27.06.16
 */

import com.gordon_from_blumberg.game.entity.GameEntity;

import javax.swing.*;

/**
 * Abstract game entity drawer
 */
public abstract class AbstractGameEntityDrawer<E extends GameEntity>
        extends JComponent
        implements GameEntityDrawer<E> {

}
