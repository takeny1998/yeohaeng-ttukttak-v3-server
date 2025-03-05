package com.yeohaeng_ttukttak.server.domain.region;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
public class Region {

    @Id
    private Long id;

    private int level;

    private String name;

    @Embedded @NotNull
    private RegionCode code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Region parent;

}
