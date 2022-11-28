package com.study.javabasic.domain;


public final class ImmutableClassDTO {
    private static final ImmutableClassDTO INSTANCE = new ImmutableClassDTO();

    // 정적 메서드를 모아 놓을 때, 생성자를 명시하지 않는 경우, Public 생성자가 만들어지므로 private 생성자를 명시하자
    private ImmutableClassDTO() {
    }

    public static ImmutableClassDTO getInstance() {
        return INSTANCE;
    }
}
