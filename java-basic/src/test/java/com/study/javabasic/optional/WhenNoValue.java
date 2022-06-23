package com.study.javabasic.optional;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class WhenNoValue {
    public static final String USER_STATUS_UNKNOWN = "UNKNOWN";

    Optional<String> basicOptional() {
        return Optional.of("BASIC");
    }

    String basic() {
        return basicOptional().get();
    }

    @Test
    void runner() {
        System.out.println(orElseNull());
    }

    /*
    * orElse는 값이 없을 때 사용될 값을 미리 세팅하는 것인데, 값이 있든 없든 ELSE 구문을 타므로 성능 저하 발생
    * */
    @Test
    String orElse() {
//        Optional<String> status = Optional.empty();
        Optional<String> status = basicOptional();

//        if (status.isPresent()) {
//            return status.get();
//        } else {
//            return USER_STATUS_UNKNOWN;
//        }

        return status.orElse(USER_STATUS_UNKNOWN);
    }

    /*
    * orElseGet은 전달하려는 값이 래핑된 Optional 객체일 때 사용하라.
    * 또한 값이 명확히 없을 때만 elseGet을 수행하므로 orElse보다 성능상의 이점을 가진다.
    * */
    @Test
    String orElseGet() {
        Optional<String> status = basicOptional();
        return status.orElseGet(this::basic);
    }

    /*
    * orElseThrow는 값이 없을 때, NoSuchElementException을 던진다.
    * */
    @Test
    String orElseThrow() {
        Optional<String> status = Optional.empty();
        return status.orElseThrow();
    }

    /*
    * orElseThrow(인수-exception)은 NoSuchElementException 외의 Exception을 던지고 싶을 때 사용
    * */
    @Test
    String orElseThrowEtc() {
        Optional<String> status = Optional.empty();
        return status.orElseThrow(IllegalStateException::new);
    }

    /*
    * optional의 Null 참조가 필요한 경우 orElse(null)을 사용하자.
    *
    * */
    @Test
    String orElseNull() {
        Optional<String> status = Optional.empty();
        return status.orElse(null);
    }
}
