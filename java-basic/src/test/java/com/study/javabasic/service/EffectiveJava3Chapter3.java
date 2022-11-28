package com.study.javabasic.service;

import com.study.javabasic.domain.Fruits;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class EffectiveJava3Chapter3 {

    @Test
    public void 공통메서드_equals(){
        Fruits apple1 = new Fruits("APPLE");
        Fruits apple2 = new Fruits("APPLE");

        Fruits apple3 = Fruits.valueOf("APPLE");
        Fruits apple4 = Fruits.valueOf("APPLE");

        // equals 비교
        System.out.println(apple1.equals(apple2));
        System.out.println(apple3.equals(apple4));

        // hashcode 비교
        Map<Fruits, String> fruits = new HashMap<>();
        fruits.put(apple1, "사과");
        System.out.println(fruits.get(apple2));
        // hashcode 구현 전에는 fruits.get(apple2)는 null을 반환한다.
        // 논리적 동치 이지만 서로 다른 해시코드로 객체가 다르게 인식 되게 때문이다.



//        assertThat(apple3).isEqualTo(apple4);
//        assertThat(apple1).isEqualTo(apple2);
    }
}
