package com.demo.microservice.currencyconversionservice.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-conversion-service")
@Data
public class LimitsConfiguration {
    private int minimum;
    private int maximum;
}
