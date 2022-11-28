package com.study.javabasic.controller;

import com.study.javabasic.domain.ImageDTO;
import com.study.javabasic.service.TypeCheckService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/advice")
@Controller
public class SpringbootController {

    private final TypeCheckService typeCheckService;

    public SpringbootController(TypeCheckService typeCheckService) {
        this.typeCheckService = typeCheckService;
    }

    @GetMapping("/image")
    public ImageDTO getImageDTO() {
        return ImageDTO.builder()
                .code("CODE")
                .url("URL")
                .build();
    }
}
