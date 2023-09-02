package com.example.microservice.commonlibrary.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @NotNull(message = "UserName Can't be Null.")
    @NotBlank(message = "UserName Can't be Blank.")
    private String userName;

    @NotNull(message = "Password Can't be Null.")
    @NotBlank(message = "Password Can't be Blank.")
    private String password;
}
