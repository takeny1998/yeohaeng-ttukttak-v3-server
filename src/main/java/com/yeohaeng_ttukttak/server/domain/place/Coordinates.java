package com.yeohaeng_ttukttak.server.domain.place;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Getter
@Immutable
@Embeddable
public class Coordinates {

    @Column(nullable = false)
    private Double longitude;

    @Column(nullable = false)
    private Double latitude;

}
