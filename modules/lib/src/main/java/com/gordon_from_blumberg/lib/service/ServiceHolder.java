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

public final class ServiceHolder {
    private static final DictionaryService dictionaryService;

    static {
        dictionaryService = new DictionaryServiceImpl();
    }

    private ServiceHolder() {}

    public static DictionaryService getDictionaryService() {
        return dictionaryService;
    }
}
