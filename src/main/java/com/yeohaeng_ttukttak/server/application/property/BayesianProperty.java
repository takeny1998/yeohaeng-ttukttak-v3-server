package com.yeohaeng_ttukttak.server.application.property;

import jakarta.validation.constraints.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Validated
@ConfigurationProperties("bayesian")
public record BayesianProperty (
        @NotNull @DecimalMin("0.0") @DecimalMax("5.9")
        Double entireAverage,

        @NotNull @DecimalMin("0.0")
        Double coefficient
) { }
