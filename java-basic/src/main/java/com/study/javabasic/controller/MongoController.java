package com.study.javabasic.controller;

import com.study.javabasic.service.MongoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MongoController {

    private final MongoService mongoService;

    @GetMapping("/books")
    public void findAll() {
        mongoService.findAll();
    }

    @PostMapping("/book")
    public void insertBook() {
        mongoService.findAll();
    }
}
