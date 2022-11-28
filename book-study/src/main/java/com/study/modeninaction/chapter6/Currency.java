package com.study.modeninaction.chapter6;

public class Currency {
    private final String type;

    public Currency(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "type='" + type + '\'' +
                '}';
    }
}

