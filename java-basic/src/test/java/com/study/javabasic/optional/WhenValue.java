package com.study.javabasic.optional;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class WhenValue {
    public static final String USER_STATUS_UNKNOWN = "UNKNOWN";

    Optional<String> basicOptional() {
        return Optional.of("BASIC");
    }

    String basic() {
        return basicOptional().get();
    }

    @Test
    void runner() {
        System.out.println(or().get());
    }

    /*
    * ifPresent()는 return 값이 없다.
    * Optional 값이 있다면 수행하고 없다면 아무것도 하지않아도 될 때 사용하라.
    * */
    @Test
    void ifPresent() {
//        Optional<String> status = Optional.of("VALUE");
        Optional<String> status = Optional.empty();
        status.ifPresent(System.out::println);
    }

    /*
     * ifPresentOrElse()는 return 값이 없다.
     * Optional 값이 있다면 수행하고 없다면 ELSE를 수행하라.
     * */
    @Test
    void ifPresentOrElse() {
//        Optional<String> status = Optional.of("VALUE");
        Optional<String> status = Optional.empty();
        status.ifPresentOrElse(System.out::println, () -> System.out.println("Not Found"));
    }

    /*
     * or()는 래핑된 Optional을 반환한다.
     * orElseGet()은 래핑되지 않은 Optional.get()을 반환한다.
     * */
    @Test
    Optional<String> or(){
//        Optional<String> status = Optional.of("VALUE");
        Optional<String> status = Optional.empty();
        return status.or(() -> Optional.of("Not Found"));
    }

}
