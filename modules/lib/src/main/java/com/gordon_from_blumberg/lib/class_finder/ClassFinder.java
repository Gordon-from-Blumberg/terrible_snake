package com.gordon_from_blumberg.lib.class_finder;

/**
 * Copyright (c) 2017 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 1:43 027 27.04.17
 */

import com.gordon_from_blumberg.lib.utils.FileUtils;
import com.gordon_from_blumberg.lib.utils.ReflectionUtils;
import com.gordon_from_blumberg.lib.utils.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

public class ClassFinder {
    private static final String CLASS_EXTENSION = ".class";

    private final String pathPattern;

    private final List<Class<?>> classList = new ArrayList<>();

    /**
     * @param path        Path to directory or to jar file
     * @param pathPattern If specified only files which are according to this pattern will be scanned
     * @throws FileNotFoundException
     */
    public ClassFinder(String path, String pathPattern) throws FileNotFoundException {
        path = FileUtils.absolutizePath(path);
        if (!new File(path).exists()) {
            throw new FileNotFoundException(String.format("File not found for path %s", path));
        }

        pathPattern = StringUtils.isNotBlank(pathPattern) ?
                FileUtils.absolutizePath(pathPattern, path) :
                path;

        this.pathPattern = pathPattern;

        //todo use logger
        long start = System.currentTimeMillis();
        findClasses();
        System.out.println(String.format("%s classes are found in %s ms", classList.size(), System.currentTimeMillis() - start));
    }

    public ClassFinder(String path) throws FileNotFoundException {
        this(path, null);
    }

    public List<Class<?>> findByAnnotation(Class<? extends Annotation> annotationType) {
        return classList.stream()
                .filter(clazz -> clazz.getAnnotation(annotationType) != null)
                .collect(Collectors.toList());
    }

    @SuppressWarnings("unchecked")
    public <I> List<Class<? extends I>> findByInterface(Class<I> interfaceType) {
        return classList.stream()
                .filter(clazz -> clazz.isAssignableFrom(interfaceType))
                .map(clazz -> (Class<I>) clazz)
                .collect(Collectors.toList());
    }

    private void findClasses() {
        FileUtils.forEach(pathPattern, FileUtils::isJar, file -> {
            try {
                JarFile jarFile = new JarFile(file);
                Enumeration<JarEntry> jarEntries = jarFile.entries();
                System.out.println(file.getPath());

                while(jarEntries.hasMoreElements()) {
                    String entryName = jarEntries.nextElement().getName();

                    if (entryName.endsWith(CLASS_EXTENSION)) {
                        String className = entryName
                                .substring(0, entryName.length() - CLASS_EXTENSION.length())
                                .replace(FileUtils.PATH_DELIMITER, ReflectionUtils.PACKAGE_DELIMITER);

                        Class<?> clazz = ReflectionUtils.getClass(className);
                        classList.add(clazz);
                        System.out.println(String.format("%s class is found in %s", clazz.getName(), file.getPath()));
                    }
                }
            } catch(IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
