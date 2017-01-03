package com.gordon_from_blumberg.lib.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 0:36 006 06.06.16
 */

import com.google.gson.Gson;

import java.io.*;


public class JsonUtils {
    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public static void writeToJsonFile(Object object, String path) {
        File file = new File(path);
        String json = toJson(object);

        try (FileWriter writer = new FileWriter(file, false)) {
            if (!file.exists()) {
                file.createNewFile();
            }

            writer.write(json);

            writer.flush();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static <T> T readFromJsonFile(String path, Class<T> clazz) {
        File file = new File(path);

        try (FileReader reader = new FileReader(file)) {
            if (!file.exists()) {
                throw new FileNotFoundException(String.format("File %s is not found!", path));
            }

            int length = (int) file.length();
            char[] json = new char[length];

            reader.read(json);

            return fromJson(new String(json), clazz);
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
