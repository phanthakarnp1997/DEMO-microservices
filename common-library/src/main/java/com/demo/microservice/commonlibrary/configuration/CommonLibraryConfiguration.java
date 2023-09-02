package com.demo.microservice.commonlibrary.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.demo.*"})
@EntityScan(basePackages = {"com.demo.*"})
@ComponentScan(basePackages = {"com.demo.*"})
public class CommonLibraryConfiguration {
}
