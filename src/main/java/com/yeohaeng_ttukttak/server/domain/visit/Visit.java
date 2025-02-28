package com.yeohaeng_ttukttak.server.domain.visit;

import com.yeohaeng_ttukttak.server.domain.place.Place;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Immutable
@ToString
@Getter
public class Visit {

    @Id @NotNull
    private Long id;

    @NotNull
    private LocalDate visitedOn;

    @NotNull
    @DecimalMin("0.0") @DecimalMax("5.0")
    private Double rating;

    @NotNull
    @ManyToOne @JoinColumn(name = "place_id")
    private Place place;

}
