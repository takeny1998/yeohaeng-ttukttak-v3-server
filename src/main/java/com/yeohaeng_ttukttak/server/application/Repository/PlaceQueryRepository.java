package com.yeohaeng_ttukttak.server.application.Repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.yeohaeng_ttukttak.server.application.dto.PlaceDto;
import com.yeohaeng_ttukttak.server.application.dto.QPlaceDto;
import com.yeohaeng_ttukttak.server.application.property.BayesianProperty;
import com.yeohaeng_ttukttak.server.domain.place.QPlace;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import com.yeohaeng_ttukttak.server.domain.visit.QVisit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceQueryRepository {

    private final JPAQueryFactory queryFactory;

    private final BayesianProperty bayesianProperty;

    public List<PlaceDto> findAllByRegionCode(final String stringCode) {
        final RegionCode regionCode = RegionCode.fromString(stringCode);

        final QPlace place = QPlace.place;
        final QVisit visit = QVisit.visit;

        final NumberExpression<Long> visitCount = visit.countDistinct();
        final NumberExpression<Double> ratingAvg = calBayesianAvg(visit.rating.sum(), visitCount);

        return queryFactory.select(new QPlaceDto(place, ratingAvg, visitCount)).from(visit)
                .join(visit.place, place)
                .where(eqRegionCode(place, regionCode))
                .groupBy(place)
                .orderBy(ratingAvg.desc(), visitCount.desc(), place.id.asc())
                .fetch();
    }

    private BooleanExpression eqRegionCode(final QPlace place, final RegionCode regionCode) {
        return place.region.code.level1.eq(regionCode.getLevel1())
                .and(place.region.code.level2.eq(regionCode.getLevel2()));
    }


    /**
     * 베이지안 평균을 계산해 반환합니다.
     *
     * <p>
     * 베이지안 평균은 전체 평균과 데이터의 평균을 바탕으로 가중치를 두어 계산됩니다.
     * <br>
     * Bayesian Avg = &frac{(C &times; 전체 평균) + 평균값}{C + 데이터 개수}
     * </p>
     *
     * @param sum 관광지별 평점의 합계
     * @param count 방문 수
     * @return 계산된 베이지안 평균
     */
    private NumberExpression<Double> calBayesianAvg(
            final NumberExpression<Double> sum, final NumberExpression<Long> count) {

        final NumberExpression<Double> upperHand = Expressions.asNumber(
                bayesianProperty.entireAverage() * bayesianProperty.coefficient()).add(sum);

        final NumberExpression<Long> lowerHand = count.add(bayesianProperty.coefficient());

        return upperHand.divide(lowerHand);
    }

}
