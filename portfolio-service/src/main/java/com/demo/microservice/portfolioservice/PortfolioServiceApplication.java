package com.demo.microservice.portfolioservice;

import com.example.microservice.commonlibrary.annotation.EnableCommonLibrary;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCommonLibrary
@ComponentScan(basePackages = {"com.example.microservice.commonlibrary" , "com.demo.microservice.portfolioservice"})
@OpenAPIDefinition(info = @Info(title = "portfolio-api-doc", version = "1.0", description = "portfolio-api-doc"))
public class PortfolioServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioServiceApplication.class, args);
    }

}
