package com.study.javabasic.domain;

import lombok.Getter;

@Getter
public enum StreamCodeEnum {
    stream70("4k"),
    stream60("1440p"),
    stream50("1080p"),
    stream40("720p"),
    stream30("540p"),
    stream20("360p"),
    stream25("480p");

    private String description;

    StreamCodeEnum(String description) {
        this.description = description;
    }
}

