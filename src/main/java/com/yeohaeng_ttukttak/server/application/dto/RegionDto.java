package com.yeohaeng_ttukttak.server.application.dto;

import com.yeohaeng_ttukttak.server.domain.region.Region;
import lombok.*;


@ToString @Getter
@EqualsAndHashCode
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public final class RegionDto {

    private final String code;
    private final String name;

    public static RegionDto fromEntity(final Region region) {
        return new RegionDto(region.getCode().serialize(), region.serialize());
    }

}