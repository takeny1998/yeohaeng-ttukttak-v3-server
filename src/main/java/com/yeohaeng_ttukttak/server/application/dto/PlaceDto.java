package com.yeohaeng_ttukttak.server.application.dto;

import com.yeohaeng_ttukttak.server.domain.place.RegionCode;

public record PlaceDto(
        Long id,
        String name,
        RegionCode regionCode,
        Double longitude,
        Double latitude
) {

}
