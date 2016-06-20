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
}
