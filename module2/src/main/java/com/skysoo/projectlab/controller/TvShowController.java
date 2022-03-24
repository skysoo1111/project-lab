package com.skysoo.projectlab.controller;

import com.skysoo.projectlab.service.TvShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TvShowController {
    private final TvShowService tvShowService;

    @PostMapping("/v1/save")
    public ResponseEntity<String> saveTvShow() {
        tvShowService.saveTvShow();
        return new ResponseEntity(HttpStatus.OK);
    }
}
