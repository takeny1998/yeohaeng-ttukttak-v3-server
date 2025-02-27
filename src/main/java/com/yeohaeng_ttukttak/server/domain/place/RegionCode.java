package com.yeohaeng_ttukttak.server.domain.place;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.springframework.util.Assert;

import java.util.Objects;

@Immutable
@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RegionCode {

    @NotNull
    @Positive
    private int level1, level2;

    @NotNull
    @PositiveOrZero
    private int level3, level4;

    public static RegionCode fromString(final String string) {

        Assert.isTrue(string.length() == 10, "지역 코드는 10자리여야 합니다.");
        Assert.isTrue(string.matches("\\d+"), "지역코드는 숫자로만 이루어져야 합니다.");

        int level1 = Integer.parseInt(string.substring(0, 2));
        int level2 = Integer.parseInt(string.substring(2, 5));
        int level3 = Integer.parseInt(string.substring(5, 8));
        int level4 = Integer.parseInt(string.substring(8, 10));

        return new RegionCode(level1, level2, level3, level4);

    }

    @Override
    public String toString() {
        return String.format("%02d%03d%03d%02d", level1, level2, level3, level4);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        final RegionCode other = (RegionCode) obj;

        return (isEqualOrZero(this.level1, other.level1) &&
                isEqualOrZero(this.level2, other.level2) &&
                isEqualOrZero(this.level3, other.level3) &&
                isEqualOrZero(this.level4, other.level4));
    }

    private boolean isEqualOrZero(int thisLevel, int otherLevel) {
        return (thisLevel == otherLevel || thisLevel == 0 || otherLevel == 0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(level1, level2, level3, level4);
    }
}
