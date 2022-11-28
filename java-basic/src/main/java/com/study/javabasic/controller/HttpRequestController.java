package com.study.javabasic.controller;

import com.study.javabasic.domain.Fruits;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
public class HttpRequestController {

//    @ResponseBody
    @RequestMapping("/requestBody")
    public ResponseEntity<?> requestBodyWithList(@RequestBody Map<String,List<String>> fruits) {

        return ResponseEntity.ok().body(fruits);
    }

    @RequestMapping("/requestBodyWithDTO")
    public ResponseEntity<?> requestBodyWithList(@RequestBody Fruits fruits) {

        return ResponseEntity.ok().body(fruits);
    }
}
