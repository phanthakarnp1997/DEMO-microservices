package com.demo.microservice.currencyconvensionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrencyConvensionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConvensionServiceApplication.class, args);
    }

}
