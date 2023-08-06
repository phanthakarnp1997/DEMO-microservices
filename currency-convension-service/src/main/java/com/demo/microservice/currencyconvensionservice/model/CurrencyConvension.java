package com.demo.microservice.currencyconvensionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConvension {
    private Long id;
    private String from;
    private String to;
    private BigDecimal convensionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private String environment;
}
