package com.gordon_from_blumberg.lib.service;

/**
 * Copyright (c) 2017 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 1:22 030 30.04.17
 */

import com.gordon_from_blumberg.lib.dictionary.DictionaryService;
import com.gordon_from_blumberg.lib.dictionary.DictionaryServiceImpl;
import com.gordon_from_blumberg.lib.path.PathService;
import com.gordon_from_blumberg.lib.path.PathServiceImpl;

public final class ServiceHolder {
    private static final PathService pathService;
    private static final DictionaryService dictionaryService;

    static {
        pathService = new PathServiceImpl();
        dictionaryService = new DictionaryServiceImpl();
    }

    private ServiceHolder() {
    }

    public static PathService getPathService() {
        return pathService;
    }

    public static DictionaryService getDictionaryService() {
        return dictionaryService;
    }
}
