package com.yeohaeng_ttukttak.server.application.dto;

import com.querydsl.core.annotations.QueryProjection;
import com.yeohaeng_ttukttak.server.domain.place.Place;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@Getter @EqualsAndHashCode @ToString
public final class PlaceDto {

    private final Long id;

    private final String name;

    private final RegionDto region;

    private final Double longitude;

    private final Double latitude;

    private final Double rating;

    private final Long visitCount;

    private final List<PlaceImageDto> images;

    @QueryProjection
    public PlaceDto(final Place place, final Double rating, final Long visitCount) {
        this.id = place.getId();
        this.name = place.getName();
        this.region = RegionDto.fromEntity(place.getRegion());
        this.longitude = place.getCoordinates().getLongitude();
        this.latitude = place.getCoordinates().getLatitude();

        this.images = place.getImages().stream()
                .map(PlaceImageDto::fromEntity)
                .toList();

        this.rating = rating;
        this.visitCount = visitCount;
    }

}
