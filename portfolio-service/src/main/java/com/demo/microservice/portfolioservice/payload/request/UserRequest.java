package com.demo.microservice.portfolioservice.payload.request;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String aboutMe;
}
