package com.demo.microservice.currencyconvensionservice.controller;

import com.demo.microservice.currencyconvensionservice.configuration.LimitsConfiguration;
import com.demo.microservice.currencyconvensionservice.model.CurrencyConversion;
import com.demo.microservice.currencyconvensionservice.proxy.CurrencyExchangeProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @Autowired
    private LimitsConfiguration configuration;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
//    @RateLimiter(name = "currency-conversion-rateLimiter")
    @CircuitBreaker(name = "currency-conversion-service", fallbackMethod = "getDefaultExchange")
    public ResponseEntity<CurrencyConversion> getCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        CurrencyConversion currencyConversion = proxy.getExchangeValue(from, to);
        CurrencyConversion result = new CurrencyConversion(currencyConversion.getId(),
                currencyConversion.getFrom(),
                currencyConversion.getTo(),
                currencyConversion.getConversionMultiple(),
                quantity,
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment());

        return new ResponseEntity(result, HttpStatus.OK);
    }

    public ResponseEntity<CurrencyConversion> getDefaultExchange(Exception e) {
        return new ResponseEntity(new CurrencyConversion(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
