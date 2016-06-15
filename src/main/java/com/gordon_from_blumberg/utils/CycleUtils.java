package com.gordon_from_blumberg.utils;

/**
 * Copyright (c) 2016 Gordon from Blumberg
 * <p>
 * Project: Terrible snake
 *
 * @author: gordon
 * Created: 22:13 015 15.06.16
 */

public class CycleUtils {
    public static int refine(int value, int period) {
        int result = value % period;

        return result >= 0 ?
                result :
                result + period;
    }

    //todo: think how to implement
    public static boolean isBeetwen(int value, int first, int second) {
        return true;
    }
}
