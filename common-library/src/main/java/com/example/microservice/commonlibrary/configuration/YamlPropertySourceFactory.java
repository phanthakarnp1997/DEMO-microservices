package com.example.microservice.commonlibrary.configuration;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

import static org.springframework.beans.factory.config.YamlProcessor.MatchStatus.*;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String activeProfile = Optional.ofNullable(System.getenv("SPRING_PROFILES_ACTIVE"))
                .orElse(System.getProperty("spring.profiles.active"));

        assert activeProfile != null;

        YamlPropertiesFactoryBean yamlFactory = new YamlPropertiesFactoryBean();
        yamlFactory.setDocumentMatchers(properties -> {
            String profileProperty = properties.getProperty("spring.profiles");

            if (StringUtils.isEmpty(profileProperty)) {
                return ABSTAIN;
            }

            return profileProperty.contains(activeProfile) ? FOUND : NOT_FOUND;
        });
        yamlFactory.setResources(resource.getResource());

        Properties properties = yamlFactory.getObject();

        assert properties != null;
        return new PropertiesPropertySource(Objects.requireNonNull(resource.getResource().getFilename()), properties);
    }
}
