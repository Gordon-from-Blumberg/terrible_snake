package com.gordon_from_blumberg.service.impl;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:43 020 20.06.16
 */

import com.gordon_from_blumberg.service.DictionaryService;
import com.gordon_from_blumberg.service.ServiceManager;
import com.gordon_from_blumberg.utils.ProperiesUtils;
import com.gordon_from_blumberg.utils.StringUtils;

import java.io.File;
import java.nio.file.Path;

/**
 * Base implementation of the DictionaryService
 */
public class DictionaryServiceImpl implements DictionaryService {
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DICTIONARY_DIR = "dictionary/";
    private static final String DICTIONARY_PROPERTIES = "dictionary.properties";

    private Path dictionaryPath;
    private String currentLanguage;

    public DictionaryServiceImpl() {
        currentLanguage = DEFAULT_LANGUAGE;
        dictionaryPath = ServiceManager.getPathService()
                .getRunningDirPath().resolve(DICTIONARY_DIR);
    }

    @Override
    public String getMessage(String messageCode) {
        return ProperiesUtils.getProperty(getDictionaryFile(), messageCode);
    }

    @Override
    public String getCurrentLanguage() {
        return currentLanguage;
    }

    @Override
    public void setCurrentLanguage(String language) {
        if (StringUtils.isBlank(language)) {
            language = DEFAULT_LANGUAGE;
        }

        currentLanguage = language;
    }

    private File getDictionaryFile() {
        String dictionaryFileName = currentLanguage.equals(DEFAULT_LANGUAGE) ?
                DICTIONARY_PROPERTIES :
                currentLanguage + "-" + DICTIONARY_PROPERTIES;

        File dictionaryFile = dictionaryPath.resolve(dictionaryFileName).toFile();

        if (!dictionaryFile.exists()) {
            throw new RuntimeException(String.format("File %s not found!", dictionaryFileName));
        }

        return dictionaryFile;
    }
}
