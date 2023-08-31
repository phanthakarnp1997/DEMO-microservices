package com.demo.microservice.apigateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {
    @Value("${server.port}")
    private String port;

    @Autowired
    private SwaggerUIProperties swaggerUIProperties;

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("portfolio-route", p -> p
                .path("/api/portfolio/**")
                .uri("lb://portfolio-service"));

        routes.route("authenticate-route", p -> p
                .path("/api/authenticate/**")
                .uri("lb://portfolio-service"));

        routes.route("openapi-route", p -> p
                .path("/v3/api-docs/**")
                .filters(f -> f.rewritePath("/v3/api-docs/(?<path>.*)", "/${path}/v3/api-docs"))
                .uri("http://localhost:" + port));

        // Add dynamically swagger configured routes
        for (SwaggerUIProperties.UrlConfiguration urlConfiguration : swaggerUIProperties.getUrls()) {
            routes.route(urlConfiguration.getName(), p -> p
                    .path(urlConfiguration.getUrl())
                    .uri("lb://" + urlConfiguration.getName()));
        }

        return routes.build();
    }
}
