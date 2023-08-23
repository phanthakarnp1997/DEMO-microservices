package com.demo.microservice.portfolioservice.exception;

import com.demo.microservice.portfolioservice.payload.ApiResponse;
import com.demo.microservice.portfolioservice.payload.ErrorResponse;
import com.demo.microservice.portfolioservice.util.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    private ResponseEntity<ApiResponse> createErrorResponse(HttpStatus status, int errorCode, String message, String description) {
        ErrorResponse errorResponse = new ErrorResponse(errorCode, new Date(), message, description);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setError(errorResponse);
        return new ResponseEntity<>(apiResponse, status);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse> badRequestExceptionHandler(BadRequestException ex, WebRequest webRequest) {
        int errorCode = (ex.getErrorCode() > 0) ? ex.getErrorCode() : -1;
        return createErrorResponse(HttpStatus.BAD_REQUEST, errorCode, ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> notfoundExceptionHandler(NotFoundException ex, WebRequest webRequest) {
        int errorCode = (ex.getErrorCode() > 0) ? ex.getErrorCode() : -1;
        return createErrorResponse(HttpStatus.NOT_FOUND, errorCode, ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodes.ERROR_BUSINESS_CODE_1, ex.getMessage(), webRequest.getDescription(false));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, WebRequest webRequest) {
        return createErrorResponse(HttpStatus.BAD_REQUEST, -1, ex.getMessage(), webRequest.getDescription(false));
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
