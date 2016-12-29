package com.gordon_from_blumberg.service;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 20:57 025 25.06.16
 */

import com.gordon_from_blumberg.service.impl.DictionaryServiceImpl;
import com.gordon_from_blumberg.service.impl.GroovyServiceImpl;
import com.gordon_from_blumberg.service.impl.PathServiceImpl;
import com.gordon_from_blumberg.service.impl.SettingsServiceImpl;
import com.gordon_from_blumberg.utils.ReflectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps the instances of services
 * and implements the static methods for the access to them
 */
public final class ServiceHolder {

    private static final Map<Class<?>, Object> serviceMap = new HashMap<>();

    public static void init() {
        getServices().entrySet()
                .stream()
                .forEach(entry -> serviceMap.put(
                                entry.getKey(),
                                ReflectionUtils.newInstanceOf(entry.getValue())
                        )
                );
    }

    @SuppressWarnings("unchecked")
    public static <S> S getService(Class<S> serviceType) {
        Object service = serviceMap.get(serviceType);

        if (service == null) {
            throw new NullPointerException(String.format("Service does not exist for type %s", serviceType.getName()));
        }

        return (S) service;
    }

    //todo get this map from config
    private static Map<Class<?>, Class<?>> getServices() {
        Map<Class<?>, Class<?>> services = new HashMap<>();
        services.put(DictionaryService.class, DictionaryServiceImpl.class);
        services.put(GroovyService.class, GroovyServiceImpl.class);
        services.put(PathService.class, PathServiceImpl.class);
        services.put(SettingsService.class, SettingsServiceImpl.class);
        return services;
    }
}
