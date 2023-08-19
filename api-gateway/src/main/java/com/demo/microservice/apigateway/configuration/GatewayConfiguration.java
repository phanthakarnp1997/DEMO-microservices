package com.demo.microservice.apigateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/get")
//                        .filters(f -> f.addRequestHeader("", ""))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/portfolio/**")
                        .uri("lb://portfolio-service"))
                .build();
    }
}
