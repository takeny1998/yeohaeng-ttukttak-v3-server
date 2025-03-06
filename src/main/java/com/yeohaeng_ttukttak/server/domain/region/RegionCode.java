package com.yeohaeng_ttukttak.server.domain.region;

import jakarta.annotation.Nullable;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.Immutable;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Immutable
@Embeddable
@EqualsAndHashCode
@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegionCode {

    @NotNull
    @Size(min = 1, max = 5)
    private Integer level;

    @Nullable
    @PositiveOrZero
    private Integer level1, level2, level3, level4;

    private static final String STRING_FORMAT = "%02d%03d%03d%02d";

    @Builder(access = AccessLevel.PACKAGE)
    public RegionCode(Integer level,
                      @Nullable Integer level1,
                      @Nullable Integer level2,
                      @Nullable Integer level3,
                      @Nullable Integer level4) {
        this.level = level;
        this.level1 = level1;
        this.level2 = level2;
        this.level3 = level3;
        this.level4 = level4;
    }

    public static RegionCode fromString(final String string) {

        Assert.isTrue(string.length() == 10, "지역 코드는 10자리여야 합니다.");
        Assert.isTrue(string.matches("\\d+"), "지역코드는 숫자로만 이루어져야 합니다.");

        final Integer level1 = Integer.parseInt(string.substring(0, 2));
        final Integer level2 = Integer.parseInt(string.substring(2, 5));
        final Integer level3 = Integer.parseInt(string.substring(5, 8));
        final Integer level4 = Integer.parseInt(string.substring(8, 10));

        final int level = (int) Stream.of(level1, level2, level3, level4)
                .filter(Objects::nonNull)
                .count() + 1;

        return new RegionCode(level, level1, level2, level3, level4);
    }

    /**
     * 지정한 레벨에 따라 하위 RegionCode를 새로 만들어 반환합니다.
     *
     * @param regionCode 법정동 코드; {@code regionCode != null}
     * @param level 새로운 레벨; {@code level != null && 0 < level < 6}
     * @return 하위 레벨을 가지는 법정동 코드
     *  - (regionCode(11, 110, 103, NULL), level=1) => RegionCode(NULL, NULL, NULL, NULL)
     *  - (regionCode(11, 110, 103, NULL), level=2) => RegionCode(11, NULL, NULL, NULL)
     *  - (regionCode(11, 110, 103, NULL), level=3) => RegionCode(11, 110, NULL, NULL)
     *  - (regionCode(11, 110, 103, NULL), level=4) => RegionCode(11, 110, 103, NULL)
     */
    public static RegionCode withLowerLevel(final RegionCode regionCode, Integer level) {

        Assert.notNull(regionCode, "regionCodoe는 필수 값입니다.");
        Assert.notNull(level, "level은 필수 값입니다.");
        Assert.isTrue(0 < level && level < 6, "level은 1부터 4까지의 정수여야 합니다.");
        Assert.isTrue(level < regionCode.getLevel(), "현재보다 하위 레벨을 지정해야 합니다.");

        if (level == 1) {
            return new RegionCode(level, null, null, null, null);
        }

        final Integer level1 = regionCode.getLevel1();
        if (level == 2) {
            return new RegionCode(level, level1, null, null, null);
        }

        final Integer level2 = regionCode.getLevel2();
        if (level == 3) {
            return new RegionCode(level, level1, level2, null, null);
        }

        final Integer level3 = regionCode.getLevel3();
        if (level == 4) {
            return new RegionCode(level, level1, level2, level3, null);
        }

        return new RegionCode(level, level1, level2, level3, regionCode.getLevel4());
    }

    public String serialize() {
        final List<Integer> levels = Stream.of(getLevel1(), getLevel2(), getLevel3(), getLevel4())
                .map(level -> level != null ? level : 0)
                .toList();

        return STRING_FORMAT.formatted(levels.get(0), levels.get(1), levels.get(2), levels.get(3));
    }

}
