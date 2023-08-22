package com.demo.microservice.apigateway.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties("springdoc.swagger-ui")
@Data
public class SwaggerUIProperties {
    private List<UrlConfiguration> urls = new ArrayList<>();

    @Data
    public static class UrlConfiguration {
        private String url;
        private String name;
        private String displayName;
    }
}
