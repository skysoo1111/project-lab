package com.study.javabasic.domain;

import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@Setter
public class BookDTO {
    private String name;
    private String author;
}
