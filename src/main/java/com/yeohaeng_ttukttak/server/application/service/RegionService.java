package com.yeohaeng_ttukttak.server.application.service;

import com.yeohaeng_ttukttak.server.application.Repository.RegionCodeRepository;
import com.yeohaeng_ttukttak.server.application.Repository.RegionRepository;
import com.yeohaeng_ttukttak.server.application.dto.RegionDto;
import com.yeohaeng_ttukttak.server.domain.region.Region;
import com.yeohaeng_ttukttak.server.domain.region.RegionCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class RegionService {

    private final RegionRepository repository;

    private final RegionCodeRepository codeRepository;

    public RegionDto findByCoords(
            final int level, final double longitude, final double latitude) {

        final RegionCode foundRegionCode = codeRepository
                .findByCoords(longitude, latitude)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        System.out.println("foundRegionCode = " + foundRegionCode);

        final RegionCode regionCode = RegionCode.withLowerLevel(foundRegionCode, level);

        System.out.println("regionCode = " + regionCode);

        final Region region = repository.findByCode(regionCode)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return RegionDto.fromEntity(region);
    }

}
