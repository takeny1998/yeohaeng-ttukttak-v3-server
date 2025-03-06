package com.yeohaeng_ttukttak.server.domain.region;

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

    @Test
    void withLowerLevelTest() {
        // Given
        final RegionCode regionCode = RegionCode.builder()
                .level(4).level1(11).level2(110).level3(103).build();

        final RegionCode codeLevel1 = RegionCode.builder()
                .level(1).level1(0).level2(0).level3(0).level4(0).build();

        final RegionCode codeLevel2 = RegionCode.builder()
                .level(2).level1(11).level2(0).level3(0).level4(0).build();

        final RegionCode codeLevel3 = RegionCode.builder()
                .level(3).level1(11).level2(110).level3(0).level4(0).build();

        // When
        final RegionCode withLevel1 = RegionCode.withLowerLevel(regionCode, 1);
        final RegionCode withLevel2 = RegionCode.withLowerLevel(regionCode, 2);
        final RegionCode withLevel3 = RegionCode.withLowerLevel(regionCode, 3);

        // Then
        assertThat(withLevel1).isEqualTo(codeLevel1);
        assertThat(withLevel2).isEqualTo(codeLevel2);
        assertThat(withLevel3).isEqualTo(codeLevel3);
    }

    @Test
    void serializeTest() {
        // Given
        final RegionCode regionCode = RegionCode.builder()
                .level1(11).level2(110).level3(103).level4(0).build();
        final String expectString = "1111010300";

        // When
        final String string = regionCode.serialize();

        // Then
        assertThat(string).isEqualTo(expectString);
    }

    @Test
    void equalsTest() {
        // Given
        final RegionCode regionCode = RegionCode.builder()
                .level(4).level1(11).level2(110).level3(103).build();

        final RegionCode regionCode2 = RegionCode.builder()
                .level(4).level1(11).level2(110).level3(103).build();

        // When
        boolean isEquals = regionCode.equals(regionCode2);

        // Then
        assertThat(isEquals).isTrue();
    }

}