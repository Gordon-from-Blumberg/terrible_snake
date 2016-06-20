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

public class ProperiesUtils {
    public static Properties getProperties(File file) {
        Properties properties = new Properties();

        try (FileInputStream inputStream = new FileInputStream(file)) {
            properties.load(inputStream);
            inputStream.close();
            return properties;

        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(Properties properties, String key) {
        String property = properties.getProperty(key);

        try {
            return new String(property.getBytes("ISO8859-1"));
        } catch(NullPointerException | UnsupportedEncodingException e) {
            System.out.print(e); //todo Use log
            return "";
        }
    }

    public static String getProperty(File file, String key) {
        return getProperty(getProperties(file), key);
    }
}
