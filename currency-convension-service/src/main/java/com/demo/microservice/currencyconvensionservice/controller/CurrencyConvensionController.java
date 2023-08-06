package com.demo.microservice.currencyconvensionservice.controller;

import com.demo.microservice.currencyconvensionservice.model.CurrencyConvension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConvensionController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvension getCurrencyConvension(@PathVariable String from, @PathVariable String to, @PathVariable String quantity) {
        return new CurrencyConvension(1001L,"USD","THB", BigDecimal.valueOf(65),BigDecimal.valueOf(10),BigDecimal.valueOf(650),environment.getProperty("local.server.port"));
    }

}
