package com.yeohaeng_ttukttak.server.domain.place;

import com.yeohaeng_ttukttak.server.domain.image.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@ToString
@Getter
public class PlaceImage {

    @Id @NotNull
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "image_id")
    private Image image;

}
