package com.example.microservice.commonlibrary.payload.request;

import lombok.Data;
import lombok.NonNull;

@Data
public class AuthenticationRequest {

    @NonNull
    private String userName;

    @NonNull
    private String password;
}
