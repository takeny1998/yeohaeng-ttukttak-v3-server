package com.yeohaeng_ttukttak.server.application.Repository;

import com.yeohaeng_ttukttak.server.domain.region.Region;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RegionRepository extends JpaRepository<Region, Long> {

    Optional<Region> findByCode(RegionCode code);

}
