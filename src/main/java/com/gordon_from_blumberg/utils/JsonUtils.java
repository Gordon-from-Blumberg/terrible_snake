package com.gordon_from_blumberg.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:36 006 06.06.16
 */

import com.google.gson.Gson;


public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static void writeToJsonFile(Object object, String path) {

    }
}
