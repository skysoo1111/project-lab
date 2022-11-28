package com.study.javabasic.domain;

import lombok.Getter;
import lombok.NonNull;

import static com.google.common.base.Preconditions.checkNotNull;


@Getter
//@EqualsAndHashCode
public final class Fruits {

    private static final Fruits fruitApple = new Fruits("APPLE");
    private static final Fruits unKnownFruit = new Fruits("UNKNOWN");
    private final String type;

    public Fruits(@NonNull String type) {
        this.type = checkNotNull(type);
    }

    public static Fruits valueOf(String type) {
        try {
            return type.equals("APPLE") ? fruitApple : unKnownFruit;
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
//
    @Override
    public boolean equals(Object obj) {
        super.equals(obj);
        if (!(obj instanceof Fruits))
            return false;
        Fruits f = (Fruits) obj;
        return f.type == type;
    }

//    @Override
//    public int hashCode() {
//        return super.hashCode();
//    }
}
