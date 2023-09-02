package com.example.microservice.commonlibrary.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AuthenticationRequest {

    @NotNull(message = "Email Can't be Null.")
    @NotBlank(message = "Email Can't be Blank.")
    @Email(message = "Email Is Not valid.")
    private String email;

    @NotNull(message = "Password Can't be Null.")
    @NotBlank(message = "Password Can't be Blank.")
    private String password;
}
