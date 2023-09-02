package com.demo.microservice.commonlibrary.exception;

import com.demo.microservice.commonlibrary.payload.ApiResponse;
import com.demo.microservice.commonlibrary.util.constant.ErrorCodes;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {
    private ApiResponse apiResponse;
    private ErrorCodes errorCode = ErrorCodes.ERROR_BUSINESS_CODE_1;

    public BaseException(ErrorCodes errorCode, String message) {
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
