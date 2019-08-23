package com.lhh.pack1.post.filter;

import java.util.HashSet;
import java.util.Set;

public class SensitivewordFilter {
    public static Set<String> sensitiveUtil(String content) {
        return getSensitiveWord(content);
    }

    private static Set<String> getSensitiveWord(String content) {
        Set<String> result = new HashSet<>();

        return null;
    }
}
