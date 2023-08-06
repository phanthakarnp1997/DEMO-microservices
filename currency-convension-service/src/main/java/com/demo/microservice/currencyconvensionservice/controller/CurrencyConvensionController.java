package com.demo.microservice.currencyconvensionservice.controller;

import com.demo.microservice.currencyconvensionservice.model.CurrencyConvension;
import com.demo.microservice.currencyconvensionservice.proxy.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConvensionController {

    @Autowired
    private CurrencyExchangeProxy proxy;

    @Autowired
    private Environment environment;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConvension getCurrencyConvension(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConvension currencyConvension = proxy.getExchangeValue(from, to);

        return new CurrencyConvension(currencyConvension.getId(),
                currencyConvension.getFrom(),
                currencyConvension.getTo(),
                currencyConvension.getConversionMultiple(),
                quantity,
                quantity.multiply(currencyConvension.getConversionMultiple()),
                currencyConvension.getEnvironment());
    }

}
