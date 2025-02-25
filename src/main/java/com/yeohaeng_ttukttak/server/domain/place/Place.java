package com.yeohaeng_ttukttak.server.domain.place;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Place {

    @Id
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private PlaceType type;

    @NotNull
    private Integer locationCode;

    @Embedded
    private Coordinates coordinates;

    @Embedded
    private RegionCode regionCode;

}
