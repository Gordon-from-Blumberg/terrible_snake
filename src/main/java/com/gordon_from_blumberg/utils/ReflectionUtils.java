package com.gordon_from_blumberg.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:55 002 02.07.16
 */

import java.util.Arrays;

/**
 * Util methods for Reflection API using
 */
public class ReflectionUtils {
    /**
     * Creates the new instance of the specified class
     *
     * @param className Class name
     * @param params    Parameters for the constructor
     * @param <T>       Expected type
     * @return New instance
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstanceOf(String className, Object[] params) {
        Class[] paramClasses = Arrays.stream(params)
                .map(Object::getClass)
                .toArray(Class[]::new);

        try {
            return (T) getClass(className).getConstructor(paramClasses).newInstance(params);
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates the new instance of the class by its name
     *
     * @param className Class name
     * @param <T>       Expected type
     * @return New instance
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstanceOf(String className) {
        try {
            return (T) getClass(className).newInstance();
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Finds class by the specified name in the specified package
     *
     * @param name        Class name
     * @param packageName Package name
     * @return Class
     */
    public static Class<?> getClass(String name, String packageName) {
        return getClass(packageName + "." + name);
    }

    /**
     * Finds class by the full name
     *
     * @param fullName Full name of the required class
     * @return Class
     * @throws RuntimeException If class is not found
     */
    public static Class<?> getClass(String fullName) {
        try {
            return Class.forName(fullName);
        } catch(ClassNotFoundException e) {
            throw new RuntimeException(String.format("Class %s is not found!", fullName), e);
        }
    }
}
