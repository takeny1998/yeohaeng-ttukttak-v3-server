package com.yeohaeng_ttukttak.server.domain.region;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegionTest {

    private Region korea, seoul, jongno;

    @BeforeEach
    void initialize() {
        korea = Region.builder()
                .id(1L)
                .name("대한민국").build();

        seoul = Region.builder()
                .id(2L).name("서울특별시")
                .parent(korea).build();

        jongno = Region.builder()
                .id(3L).name("종로구")
                .parent(seoul).build();
    }

    @Test
    void serializeTest() {
        // Given
        final String expectJongnoName = "%s, %s"
                .formatted(jongno.getName(), seoul.getName());

        final String expectKoreaName = korea.getName();

        // When
        final String jongnoName = jongno.serialize();
        final String koreaName = korea.serialize();

        // Then
        assertThat(jongnoName)
                .as("부모가 있는 경우, 부모 이름이 콤마(,) 뒤에 표시된다.")
                .isEqualTo(expectJongnoName);

        assertThat(koreaName)
                .as("부모가 없는 경우, 자신의 이름만 직렬화된다.")
                .isEqualTo(expectKoreaName);
    }

}