package com.demo.microservice.portfolioservice.payload;

import lombok.*;

import java.util.List;
import java.util.Map;

@Data
public class ErrorResponse {
    private String code;
    private String message;
    private String details;
    private Map<String, List<String>> validationErrors;

}
