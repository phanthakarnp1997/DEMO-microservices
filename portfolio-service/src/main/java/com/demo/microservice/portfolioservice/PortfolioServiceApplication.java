package com.demo.microservice.portfolioservice;

import com.demo.microservice.commonlibrary.configuration.CommonLibraryConfiguration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(CommonLibraryConfiguration.class)
@OpenAPIDefinition(info = @Info(title = "portfolio-api-doc", version = "1.0", description = "portfolio-api-doc"))
public class PortfolioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServiceApplication.class, args);
    }

}
