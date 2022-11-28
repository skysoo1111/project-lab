package com.study.javabasic.service;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CompareTest {

    @Test
    public void LongNumberCompareTest() {
        Long targetDate = 20160531235959L;

        String a = targetDate.compareTo(20160601000000L) >= 0 ? testA() : testB();
        System.out.println(a);
    }

    public String testA() {
        return "2016년 6월 같거나 이후 영화";
    }

    public String testB() {
        return "2016년 6월 이전 영화";
    }

    @Test
    public void StringNumberCompareTest() {
        String targetDate = "20160531235959";

        String a = Long.valueOf(targetDate).compareTo(Long.valueOf("20160601000000")) >= 0 ? testA() : testB();
        System.out.println(a);
    }

    @Test
    void integerTest() {
//        Integer a = 1000;
//        Integer b = 1000;
//        Integer c = new Integer(1000);
//
//        System.out.println(a==b);
//        System.out.println(a==c);
//        System.out.println(a.equals(c));
//
//        Integer d = 100;
//        Integer e = 100;
//        Integer f = new Integer(100);
//
//        System.out.println(d==e);
//        System.out.println(d==f);
//        System.out.println(d.equals(f));
//
//        String g = "apple";
//        String h = new String("apple");
//
//        System.out.println(g == h);
//        System.out.println(g.equals(h));
//

        Integer i = 110;
        Integer j = 110;

        System.out.println(i==j);

        Integer k = Integer.valueOf(128);
        Integer l = Integer.valueOf(128);

        System.out.println(k==l);

        Integer m = new Integer(110);
        Integer n = new Integer(110);

        System.out.println(m==n);
    }

    @Test
    void internTest() {
        String a = "apple";
        String b = new String("apple");
        String c = b.intern();
        String d = a.intern();
        String e = new String("apple");

        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == b.intern());
        System.out.println(b==c);
        System.out.println(a==d);
        System.out.println(b.intern() == e.intern());
    }

    @Test
    void equalsTest() {
        Map paramMap = new HashMap();
        if ("CAIP0100".equals(paramMap.get("IMG_SECT1_CD")) || "CAIP0200".equals(paramMap.get("IMG_SECT1_CD")) || "CAIP0400".equals(paramMap.get("IMG_SECT1_CD"))
                || "CAIE0100".equals(paramMap.get("IMG_SECT1_CD")) || "CAIE0200".equals(paramMap.get("IMG_SECT1_CD")) || "CAIE0400".equals(paramMap.get("IMG_SECT1_CD"))
                || "CAIS0100".equals(paramMap.get("IMG_SECT1_CD")) || "CAIS0200".equals(paramMap.get("IMG_SECT1_CD")) || "CAIS0400".equals(paramMap.get("IMG_SECT1_CD"))
        ) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }

        final Set<String> IMG_SECT_1_CDS = Set.of("CAIP0100", "CAIP0200","CAIP0400","CAIE0100","CAIE0200","CAIE0400","CAIS0100","CAIS0200","CAIS0400");
        if (IMG_SECT_1_CDS.contains(paramMap.get("IMG_SECT1_CD"))) {
            System.out.println("success");
        } else {
            System.out.println("fail");
        }
    }
}
