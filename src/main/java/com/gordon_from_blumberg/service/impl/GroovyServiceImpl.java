package com.gordon_from_blumberg.service.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:03 002 02.07.16
 */

import com.gordon_from_blumberg.service.GroovyService;
import com.gordon_from_blumberg.service.PathService;
import com.gordon_from_blumberg.service.ServiceHolder;
import com.gordon_from_blumberg.service.annotation.Inject;
import com.gordon_from_blumberg.service.annotation.Injectable;
import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Base implementation of the GroovyService
 */
@Injectable("groovyService")
public class GroovyServiceImpl implements GroovyService {
    private static final String GROOVY_DIR = "groovy/";

    @Inject
    private PathService pathService;

    private final Path groovyPath;

    private GroovyScriptEngine engine;

    public GroovyServiceImpl() {
        groovyPath = ServiceHolder.getService(PathService.class).getResourceDir(GROOVY_DIR);
        try {
            engine = new GroovyScriptEngine(new String[] {groovyPath.toString()});
        } catch(IOException e) {
            throw new RuntimeException("Couldn't instantiate the GroovyScriptEngine", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T execute(String scriptPath, Map<String, Object> params) {
        try {
            return (T) engine.run(scriptPath, new Binding(params));
        } catch(Exception e) {
            throw new RuntimeException(
                    String.format("Couldn't run the script %s with params %s", scriptPath, params),
                    e
            );
        }
    }
}
