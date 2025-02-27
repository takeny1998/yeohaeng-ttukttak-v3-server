package com.yeohaeng_ttukttak.server.application.converter;

import com.yeohaeng_ttukttak.server.domain.place.RegionCode;
import org.springframework.core.convert.converter.Converter;

public class StringToRegionCodeConverter implements Converter<String, RegionCode> {

    @Override
    public RegionCode convert(String source) {
        return RegionCode.fromString(source);
    }

}
