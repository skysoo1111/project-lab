package com.study.javabasic.controller;

import java.util.List;

public class Overriding {
    public static void main(String[] args) {
        List<Wine> wineList = List.of(new Wine(), new SparklingWine(), new Champagne());

        // 컴파일타임에서는 Wine
        for (Wine wine : wineList) {
            System.out.println(wine.name());
        }
    }
}
class Wine {
    String name() {
        return "포도주";
    }
}
class SparklingWine extends Wine {
    @Override String name() {
        return "발포성 포도주";
    }
}
class Champagne extends SparklingWine {
    @Override String name() {
        return "샴페인";
    }
}
