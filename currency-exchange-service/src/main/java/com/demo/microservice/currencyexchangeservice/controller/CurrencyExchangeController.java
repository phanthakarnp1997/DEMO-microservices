package com.demo.microservice.currencyexchangeservice.controller;

import com.demo.microservice.currencyexchangeservice.model.CurrencyExchange;
import com.demo.microservice.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ResponseEntity<CurrencyExchange> getExchangeValue(@PathVariable String from, @PathVariable String to) {
        CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);

        if (currencyExchange == null)
            throw new RuntimeException(String.format("Not found from=%s to=%s", from, to));

        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));

        return new ResponseEntity(currencyExchange, HttpStatus.OK);
    }

}
