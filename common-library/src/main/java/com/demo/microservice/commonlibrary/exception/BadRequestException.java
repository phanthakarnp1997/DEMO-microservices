package com.demo.microservice.commonlibrary.exception;

import com.demo.microservice.commonlibrary.payload.ApiResponse;
import com.demo.microservice.commonlibrary.util.constant.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends BaseException {

    public BadRequestException(ErrorCodes errorCode, String message) {
        super(errorCode, message);
    }

    public BadRequestException(ApiResponse apiResponse) {
        super(apiResponse);
    }

    public BadRequestException(String message) {
        super(message);
    }

    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
