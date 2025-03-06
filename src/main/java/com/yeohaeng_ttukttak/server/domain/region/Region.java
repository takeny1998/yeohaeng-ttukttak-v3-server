package com.yeohaeng_ttukttak.server.domain.region;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Region {

    @Id
    private Long id;

    private String name;

    @Embedded
    @NotNull
    private RegionCode code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Region parent;

    @Builder(access = AccessLevel.PACKAGE)
    Region(Long id,  String name, RegionCode code, Region parent) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.parent = parent;
    }

    /**
     * 상위 지역과 콤마(,)로 구분된 지역 이름을 반환합니다.
     *
     * @return 상위 지역이 있으면 {@code 서울특별시, 대한민국}; 없으면 {@code 대한민국}
     */
    public String serialize() {
        final StringBuilder nameBuilder = new StringBuilder();

        nameBuilder.append(getName());

        if (this.getParent() != null) {
            nameBuilder.append(", ").append(getParent().getName());
        }

        return nameBuilder.toString();
    }

}