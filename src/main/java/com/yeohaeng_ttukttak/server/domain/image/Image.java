package com.yeohaeng_ttukttak.server.domain.image;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

@Entity
@Getter
@Immutable
@ToString
public class Image {

    @Id @NotNull
    private Long id;

    @NotNull
    private String url;

}
