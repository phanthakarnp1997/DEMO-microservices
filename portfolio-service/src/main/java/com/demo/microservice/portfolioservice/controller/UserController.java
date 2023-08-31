package com.demo.microservice.portfolioservice.controller;

import com.demo.microservice.portfolioservice.model.User;
import com.demo.microservice.portfolioservice.payload.request.UserRequest;
import com.demo.microservice.portfolioservice.service.UserService;
import com.example.microservice.commonlibrary.payload.ApiResponse;
import com.example.microservice.commonlibrary.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/portfolio/v1")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResponse<List<User>>> getUsers() {
        List<User> users = userService.getUsers();
        ApiResponse<List<User>> response = new ApiResponse<>("Success", null, users, null);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        ApiResponse<User> response = new ApiResponse<>("Success", null, user, null);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/user")
    public ResponseEntity<ApiResponse<User>> createUser(@RequestBody UserRequest userRequest) {
        User newUser = userService.saveUser(userRequest);
        ApiResponse<User> response = new ApiResponse<>("User created", null, newUser, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        User updatedUser = userService.updateUser(id, userRequest);
        ApiResponse<User> response = new ApiResponse<>("User updated", null, updatedUser, null);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {
        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            ApiResponse<Void> response = new ApiResponse<>("User deleted", null, null, null);
            return ResponseEntity.ok(response);
        } else {
            ErrorResponse errorResponse = new ErrorResponse("404", new Date(), "User not found", "The specified user does not exist");
            ApiResponse<Void> response = new ApiResponse<>("User deletion failed", null, null, errorResponse);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

}
