package com.gordon_from_blumberg.lib.application;

/**
 * Copyright (c) 2017 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 2:43 009 09.05.17
 * <p>
 * $Id$
 */

import com.gordon_from_blumberg.lib.class_finder.ClassFinder;
import com.gordon_from_blumberg.lib.path.PathUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.stream.Collectors;

public class AppManager {
    private JFrame frame;
    private ClassFinder classFinder;

    public AppManager() throws FileNotFoundException {
        frame = new JFrame();
        classFinder = new ClassFinder(PathUtils.getRunningDir(), "apps/*/*");
    }

    private Map<String, Class<? extends Application>> getApplicationClassList() {
        return classFinder.findByInterface(Application.class)
                .stream()
                .collect(Collectors.toMap(this::getNameCode, cls -> cls));
    }

    private String getNameCode(Class<? extends Application> clazz) {
        App appAnnotation = clazz.getAnnotation(App.class);
        return appAnnotation == null ?
                clazz.getSimpleName() :
                appAnnotation.value();
    }
}
