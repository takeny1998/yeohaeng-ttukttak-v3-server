package com.yeohaeng_ttukttak.server.domain.place;

import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void equalsTest() {

        final List<RegionCode> regionCodes = List.of(
                new RegionCode(21, 10, 0, 0),  // 0: 21 010 000 00
                new RegionCode(21, 10, 0, 0),  // 1: 21 010 000 00
                new RegionCode(21, 20, 0, 0),  // 2: 21 020 000 00
                new RegionCode(21, 10, 30, 0), // 3: 21 010 030 00
                new RegionCode(23, 10, 0, 0)   // 4: 23 010 000 00
        );

        assertThat(regionCodes.get(0))
                .as("모든 Level이 같으면 동등해야 한다.")
                .isEqualTo(regionCodes.get(1));

        assertThat(regionCodes.get(0))
                .as("한 개라도 Level이 틀리면 동등하지 않다.")
                .isNotEqualTo(regionCodes.get(4));

        assertThat(regionCodes.get(0))
                .as("한 개라도 Level이 틀리면 동등하지 않다.")
                .isNotEqualTo(regionCodes.get(2));

        assertThat(regionCodes.get(0))
                .as("level3가 다르지만, [3]의 level3이 0이므로 동등하다.")
                .isEqualTo(regionCodes.get(3));
    }

}