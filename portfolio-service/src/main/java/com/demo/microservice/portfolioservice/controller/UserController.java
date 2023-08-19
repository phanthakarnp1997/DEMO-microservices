package com.demo.microservice.portfolioservice.controller;

import com.demo.microservice.portfolioservice.model.User;
import com.demo.microservice.portfolioservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portfolio/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<User> getUser() {
        User user = userService.getUser();
        return new ResponseEntity(user, HttpStatus.OK);
    }
}
