package com.yeohaeng_ttukttak.server.domain.place;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;

import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class RegionCode {

    @NotNull @Immutable
    private int level1, level2, level3, level4;

    public static RegionCode of(String codeStr) {

        if (codeStr.length() != 10) {
            throw new IllegalArgumentException("지역코드는 10자리여야 합니다.");
        }

        try {
            int level1 = Integer.parseInt(codeStr.substring(0, 2));
            int level2 = Integer.parseInt(codeStr.substring(2, 5));
            int level3 = Integer.parseInt(codeStr.substring(5, 8));
            int level4 = Integer.parseInt(codeStr.substring(8, 10));

            return new RegionCode(level1, level2, level3, level4);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지역코드는 숫자로만 이루어져야 합니다.", e);
        }
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
