package com.gordon_from_blumberg.game.subject;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:26 015 15.06.16
 */

import com.gordon_from_blumberg.game.subject.GameRootSubject;

/**
 * Defines the builder object for the root subjects
 */
public interface GameRootSubjectBuilder<S extends GameRootSubject> {
    S build();
}
