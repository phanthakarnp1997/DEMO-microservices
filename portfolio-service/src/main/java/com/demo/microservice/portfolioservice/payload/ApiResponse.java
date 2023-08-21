package com.demo.microservice.portfolioservice.payload;

import lombok.*;

@Data
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private ErrorResponse error;
}
