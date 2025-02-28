package com.yeohaeng_ttukttak.server.application.dto;

import com.yeohaeng_ttukttak.server.domain.place.PlaceImage;

public record PlaceImageDto(
        Long id, String url
) {

    public static PlaceImageDto fromEntity(final PlaceImage placeImage) {
        return new PlaceImageDto(placeImage.getId(), placeImage.getImage().getUrl());
    }

}
