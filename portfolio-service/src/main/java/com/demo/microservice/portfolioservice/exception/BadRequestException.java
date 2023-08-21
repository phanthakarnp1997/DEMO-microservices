package com.demo.microservice.portfolioservice.exception;

import com.demo.microservice.portfolioservice.payload.ApiResponse;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    private ApiResponse apiResponse;

    public BadRequestException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

}
