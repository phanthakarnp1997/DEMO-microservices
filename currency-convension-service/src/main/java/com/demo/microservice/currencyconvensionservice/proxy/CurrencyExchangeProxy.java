package com.demo.microservice.currencyconvensionservice.proxy;

import com.demo.microservice.currencyconvensionservice.model.CurrencyConvension;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConvension getExchangeValue(@PathVariable String from, @PathVariable String to);
}
