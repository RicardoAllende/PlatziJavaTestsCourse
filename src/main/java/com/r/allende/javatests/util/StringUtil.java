package com.r.allende.javatests.util;

public class StringUtil {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static String repeat(String txt, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("times can't be negative");
        }
        String response = "";
        for (int i = 0; i < times; i++) {
            response += txt;
        }
        return response;
    }
}
