package com.demo.microservice.portfolioservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.demo.microservice.commonlibrary.repository", "com.demo.microservice.portfolioservice.repository"})
@EntityScan(basePackages = {"com.demo.microservice.commonlibrary", "com.demo.microservice.portfolioservice"})
@ComponentScan(basePackages = {"com.demo.microservice.commonlibrary", "com.demo.microservice.portfolioservice"})
@OpenAPIDefinition(info = @Info(title = "portfolio-api-doc", version = "1.0", description = "portfolio-api-doc"))
public class PortfolioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServiceApplication.class, args);
    }

}
