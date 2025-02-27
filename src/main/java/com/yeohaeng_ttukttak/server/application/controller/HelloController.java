package com.yeohaeng_ttukttak.server.application.controller;

import com.yeohaeng_ttukttak.server.application.Repository.PlaceQueryRepository;
import com.yeohaeng_ttukttak.server.application.dto.PlaceDto;
import com.yeohaeng_ttukttak.server.application.dto.VisitAggregationDto;
import com.yeohaeng_ttukttak.server.domain.place.Place;
import com.yeohaeng_ttukttak.server.domain.place.RegionCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v3")
@RequiredArgsConstructor
public class HelloController {

    private final PlaceQueryRepository placeQueryRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/places")
    public List<VisitAggregationDto> regionCode(@RequestParam @Valid RegionCode regionCode) {
        return placeQueryRepository.listByRegionCode(regionCode);
    }

}
