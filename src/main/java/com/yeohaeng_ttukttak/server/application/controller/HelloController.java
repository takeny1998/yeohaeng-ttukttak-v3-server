package com.yeohaeng_ttukttak.server.application.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
