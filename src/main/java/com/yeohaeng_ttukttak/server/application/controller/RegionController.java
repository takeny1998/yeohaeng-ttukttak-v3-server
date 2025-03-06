package com.yeohaeng_ttukttak.server.application.controller;

import com.yeohaeng_ttukttak.server.application.dto.RegionDto;
import com.yeohaeng_ttukttak.server.application.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v3/regions")
@RequiredArgsConstructor
public class RegionController {

    private final RegionService regionService;

    @GetMapping
    public Map<String, Object> findByCoords(
            @RequestParam int level, @RequestParam Double longitude, @RequestParam Double latitude) {

        final RegionDto regionDto = regionService.findByCoords(level, longitude, latitude);

        return Map.of(
                "message", "성공적으로 지역이 조회되었습니다.",
                "region", regionDto);
    }

}
