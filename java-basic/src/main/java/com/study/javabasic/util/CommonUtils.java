package com.study.javabasic.util;

public class CommonUtils {

    public static String NVL(Object obj) {

        if(obj == null) {
            return new String("");
        } else {
            return obj.toString().trim();
        }
    }

    public static String NVL(Object obj, String replace) {

        if(obj == null) {
            return replace;
        } else {
            return obj.toString().trim();
        }
    }
}
