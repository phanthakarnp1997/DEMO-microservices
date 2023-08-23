package com.demo.microservice.portfolioservice.exception;

import com.demo.microservice.portfolioservice.payload.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private ApiResponse apiResponse;
    private int errorCode;

    public BaseException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(ApiResponse apiResponse) {
        this.apiResponse = apiResponse;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
