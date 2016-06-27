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
    /**
     * Returns true if the passed string is null or empty
     *
     * @param string The string for check
     * @return True if the passed string is null or empty
     */
    public static boolean isBlank(String string) {
        return string == null || "".equals(string);
    }

    /**
     * Returns the passed string if it is not blank or the defaultString otherwise
     *
     * @param string        The passed string that can be blank
     * @param defaultString The default sting that will be used if string is blank
     * @return String or default string
     */
    public static String defaultString(String string, String defaultString) {
        return isBlank(string) ? defaultString : string;
    }
}
