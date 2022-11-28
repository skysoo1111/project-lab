package com.study.javabasic.controller.advice;

import com.study.javabasic.domain.CommonResponse;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseBodyControllerAdvice implements ResponseBodyAdvice {
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return !request.getURI().getPath().contains("actuator") && !(body instanceof CommonResponse) ? CommonResponse.builder().code("0000").message("Success").data(body).build() : body;
    }

    public ResponseBodyControllerAdvice() {
    }
}

