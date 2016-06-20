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
import com.gordon_from_blumberg.terrible_snake.Configuration;
import com.gordon_from_blumberg.utils.ProperiesUtils;
import com.gordon_from_blumberg.utils.StringUtils;

import java.io.File;
import java.util.Properties;

public class DictionaryServiceImpl implements DictionaryService {
    private static final String DEFAULT_LANGUAGE = "en";
    private static final String DICTIONARY_DIR = "src/main/dictionary/";
    private static final String DICTIONARY_PROPERTIES = "dictionary.properties";

    private String currentLanguage = DEFAULT_LANGUAGE;

    @Override
    public String getMessage(String messageCode) {
        Properties dictionaryProperties = ProperiesUtils.getProperties(getDictionaryFile());

        String message = dictionaryProperties.getProperty(messageCode);

        return message != null ? message : "";
    }

    @Override
    public void setCurrentLanguage(String language) {
        currentLanguage = language;
    }

    private File getDictionaryFile() {
        String dictionaryFileName = (StringUtils.isBlank(currentLanguage) || currentLanguage.equals(DEFAULT_LANGUAGE)) ?
                DICTIONARY_PROPERTIES :
                currentLanguage + "-" + DICTIONARY_PROPERTIES;

        return Configuration.PROJECT_DIR.resolve(DICTIONARY_DIR + dictionaryFileName).toFile();
    }
}
