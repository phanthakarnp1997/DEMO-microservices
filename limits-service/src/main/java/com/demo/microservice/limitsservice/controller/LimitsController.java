package com.demo.microservice.limitsservice.controller;

import com.demo.microservice.limitsservice.configuration.LimitsConfiguration;
import com.demo.microservice.limitsservice.model.Limits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class LimitsController {

    @Autowired
    private LimitsConfiguration configuration;

    @GetMapping("/limits")
    public ResponseEntity<Limits> getLimits() {
        return ResponseEntity.ok(new Limits(configuration.getMinimum(), configuration.getMaximum()));
    }

}
