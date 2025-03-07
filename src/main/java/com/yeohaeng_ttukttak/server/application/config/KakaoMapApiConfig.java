package com.yeohaeng_ttukttak.server.application.config;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "kakao.map")
public record KakaoMapApiConfig(
        @NotEmpty String apiKey
) { }
