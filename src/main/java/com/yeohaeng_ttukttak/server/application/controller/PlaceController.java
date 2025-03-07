package com.yeohaeng_ttukttak.server.application.controller;

import com.yeohaeng_ttukttak.server.application.Repository.PlaceQueryRepository;
import com.yeohaeng_ttukttak.server.application.dto.PlaceDto;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Validated
@RestController
@RequestMapping("/api/v3/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceQueryRepository placeQueryRepository;

    @GetMapping
    public Map<String, Object> findAllByRegionCode(
            @RequestParam @NotEmpty @Length(min = 10, max = 10) String regionCode) {

        List<PlaceDto> places = placeQueryRepository.findAllByRegionCode(regionCode);

        return Map.of(
                "message", "관광지 목록 조회가 완료되었습니다.",
                "places", places
        );
    }

}
