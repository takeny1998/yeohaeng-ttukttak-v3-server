package com.yeohaeng_ttukttak.server.application.Repository;

import com.yeohaeng_ttukttak.server.domain.region.RegionCode;

import java.util.Optional;

public interface RegionCodeRepository {

    Optional<RegionCode> findByCoords(double longitude, double latitude);

}
