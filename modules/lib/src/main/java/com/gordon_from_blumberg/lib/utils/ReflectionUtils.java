package com.gordon_from_blumberg.lib.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:55 002 02.07.16
 */

import javafx.util.Pair;

import java.util.Arrays;

/**
 * Util methods for Reflection API using
 */
public final class ReflectionUtils {
    public static final String DELIMITER = ".";

    private ReflectionUtils() {
    }

    /**
     * Creates the new instance of the specified class
     *
     * @param className Class name
     * @param params    Array of the pairs with class-object. Classes must be the same parameters
     *                  of the constructor. Objects are the parameters for the constructor
     * @param <T>       Expected type
     * @return New instance
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstanceOf(String className, Pair<Class<?>, Object>... params) {
        return newInstanceOf((Class<T>) getClass(className), params);
    }

    public static <T> T newInstanceOf(Class<T> clazz, Pair<Class<?>, Object>... params) {
        Class[] paramClasses = Arrays.stream(params)
                .map(Pair::getKey)
                .toArray(Class[]::new);

        Object[] args = Arrays.stream(params)
                .map(Pair::getValue)
                .toArray();

        try {
            return clazz.getConstructor(paramClasses).newInstance(args);
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
        return newInstanceOf((Class<T>) getClass(className));
    }

    /**
     * Creates the new instance of the passed class
     *
     * @param clazz Target class
     * @param <T>   Expected type
     * @return New instance
     */
    public static <T> T newInstanceOf(Class<T> clazz) {
        try {
            return clazz.newInstance();
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
    //todo
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

    /**
     * Returns the path relative to the package. For example, this method will return "my_package.MyClass"
     * for the com.my_company.my_project.my_package.MyClass class and the "my_project" package
     *
     * @param clazz       Class
     * @param packageName Package which relative to the path is required
     * @return Relative path
     * @throws IllegalArgumentException If the specified class is not relative to specified package
     */
    public static String getRelativeClassPath(Class<?> clazz, String packageName) {
        String[] paths = clazz.getName().split("\\" + DELIMITER);

        for (int i = 0; i < paths.length; i++) {
            if (packageName.equals(paths[i])) {
                return String.join(DELIMITER, Arrays.copyOfRange(paths, i + 1, paths.length));
            }
        }

        throw new IllegalArgumentException(String.format("Class %s is not relative to package %s!",
                clazz.getName(), packageName));
    }
}
