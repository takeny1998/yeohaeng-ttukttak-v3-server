package com.yeohaeng_ttukttak.server.application.controller;

import com.yeohaeng_ttukttak.server.domain.place.RegionCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/hello")
public class HelloController {

    @GetMapping
    public String hello() {
        return "hello";
    }

    @GetMapping("/region-code")
    public String regionCode(@RequestParam RegionCode regionCode) {
        return regionCode.toString();
    }

}
