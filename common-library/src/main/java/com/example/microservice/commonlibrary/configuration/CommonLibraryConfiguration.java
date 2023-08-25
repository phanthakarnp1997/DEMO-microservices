package com.example.microservice.commonlibrary.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:commonlibrary-application.yaml", factory = YamlPropertySourceFactory.class)
public class CommonLibraryConfiguration {
}
