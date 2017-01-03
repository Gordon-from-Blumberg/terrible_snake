package com.gordon_from_blumberg.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:25 020 20.06.16
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * Util class for work with properties files
 */
public class PropertiesUtils {
    private static final String PROPERTIES_ENCODING = "ISO8859-1";

    /**
     * Reads properties file
     *
     * @param file File with properties
     * @return Properties object
     * @throws RuntimeException if the IO exception is thrown during file reading
     */
    public static Properties readProperties(File file) {
        Properties properties = new Properties();

        try (FileInputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
            inputStream.close();
            return properties;

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds property in the passed properties object by the specified key
     * @param properties Properties object
     * @param key Property key
     * @return Found property value or empty string
     */
    public static String getProperty(Properties properties, String key) {
        String property = properties.getProperty(key);

        return property != null ?
                convert(property) :
                "";
    }

    /**
     * Finds property by the specified key in the specified file
     * @param file Properties file
     * @param key Property key
     * @return Found property value or empty string
     */
    public static String getProperty(File file, String key) {
        return getProperty(readProperties(file), key);
    }

    private static String convert(String string) {
        try {
            return new String(string.getBytes(PROPERTIES_ENCODING));
        } catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
