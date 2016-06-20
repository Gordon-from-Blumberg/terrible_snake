package com.gordon_from_blumberg.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 23:05 020 20.06.16
 */

/**
 * Util methods for work with strings
 */
public class StringUtils {
    public static boolean isBlank(String string) {
        return string == null || "".equals(string);
    }
}
