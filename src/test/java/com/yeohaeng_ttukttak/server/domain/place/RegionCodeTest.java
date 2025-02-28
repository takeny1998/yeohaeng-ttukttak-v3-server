package com.yeohaeng_ttukttak.server.domain.place;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RegionCodeTest {

    @Test
    void fromStringTest() {

        // Given
        final String numericString = "2915501000";

        // When
        final RegionCode regionCode = RegionCode.fromString(numericString);

        // Then
        assertThat(regionCode)
                .extracting(RegionCode::getLevel1, RegionCode::getLevel2, RegionCode::getLevel3, RegionCode::getLevel4)
                .containsExactly(29, 155, 10, 0);
    }

}