package com.example.microservice.commonlibrary.payload;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String status;
    private String message;
    private T data;
    private ErrorResponse error;
}
