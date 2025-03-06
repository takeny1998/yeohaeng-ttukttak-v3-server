package com.yeohaeng_ttukttak.server.domain.place;

import com.yeohaeng_ttukttak.server.domain.region.Region;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "place")
    private List<PlaceImage> images = new ArrayList<>();

}
