package com.study.javabasic.util;

public class CommonUtils {

    public static String NVL(String str) {
        if (str != null && !str.isEmpty()) {
            return str;
        } else {
            return "";
        }
    }
}
