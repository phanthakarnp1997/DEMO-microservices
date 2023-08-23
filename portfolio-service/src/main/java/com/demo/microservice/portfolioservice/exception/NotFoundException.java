package com.demo.microservice.portfolioservice.exception;

import com.demo.microservice.portfolioservice.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends BaseException {

    public NotFoundException(int errorCode, String message) {
        super(errorCode, message);
    }

    public NotFoundException(ApiResponse apiResponse) {
        super(apiResponse);
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
