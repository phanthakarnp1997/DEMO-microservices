package com.example.microservice.commonlibrary.exception;

import com.example.microservice.commonlibrary.payload.ApiResponse;
import com.example.microservice.commonlibrary.payload.ErrorResponse;
import com.example.microservice.commonlibrary.util.constant.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<ApiResponse> createErrorResponse(HttpStatus status, ErrorCodes errorCode, String message, String description) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode.getValue(), new Date(), message, description);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError(errorResponse);
        return new ResponseEntity<>(apiResponse, status);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> badRequestExceptionHandler(BadRequestException ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.BAD_REQUEST, ex.getErrorCode(), ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notfoundExceptionHandler(NotFoundException ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.NOT_FOUND, ex.getErrorCode(), ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodes.ERROR_BUSINESS_CODE_1, ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.BAD_REQUEST, ErrorCodes.DEFAULT_CODE, ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadable(ResponseStatusException ex, WebRequest webRequest) {
        HttpStatusCode httpStatus = ex.getStatusCode();
        if(httpStatus == HttpStatus.UNAUTHORIZED){
            return createErrorResponse(HttpStatus.UNAUTHORIZED, ErrorCodes.UNAUTHORIZED_CODE, ex.getMessage(), webRequest.getDescription(false));
        }
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodes.DEFAULT_CODE, ex.getMessage(), webRequest.getDescription(false));
    }

//    @ExceptionHandler(NoHandlerFoundException.class)
//    public ResponseEntity<ApiResponse> handleNotFoundException(HttpMessageNotReadableException ex, WebRequest webRequest) {
////        String message = "The requested resource was not found on this server.";
//        ErrorResponse errorResponse = new ErrorResponse(-1, new Date(), ex.getMessage(), webRequest.getDescription(false));
//        ApiResponse apiResponse = new ApiResponse();
//        apiResponse.setError(errorResponse);
//        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
//    }
}
