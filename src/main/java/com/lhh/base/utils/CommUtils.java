package com.lhh.base.utils;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class CommUtils {

    public static boolean isNull(Object obj) {
        boolean result = false;
        if (obj != null) {
            if (obj instanceof String) {
                if (((String) obj).trim().isEmpty()) {
                    result = true;
                }
            } else if (obj instanceof Collection) {
                if (((Collection) obj).isEmpty()) {
                    result = true;
                }
            } else if (obj instanceof Map) {
                if (((Map) obj).isEmpty()) {
                    result = true;
                }
            } else if (obj.getClass().isArray()) {
                if (Array.getLength(obj) <= 0) {
                    return true;
                }
            }

        } else {
            result = true;
        }
        return result;
    }
}
