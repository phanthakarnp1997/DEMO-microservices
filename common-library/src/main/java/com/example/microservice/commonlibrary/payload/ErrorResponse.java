package com.example.microservice.commonlibrary.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String statusCode;
    private Date timestamp;
    private String message;
    private String description;

}
