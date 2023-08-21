package com.demo.microservice.portfolioservice.exception;

import com.demo.microservice.portfolioservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    private ApiResponse apiResponse;

    public NotFoundException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
