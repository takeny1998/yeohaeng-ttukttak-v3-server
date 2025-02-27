package com.yeohaeng_ttukttak.server.domain.place;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
public class Place {

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private PlaceCategory category;

    @Embedded
    private Coordinates coordinates;

    @Embedded
    @NotNull
    private RegionCode regionCode;

}
