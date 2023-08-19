package com.demo.microservice.portfolioservice.service;

import com.demo.microservice.portfolioservice.model.User;
import com.demo.microservice.portfolioservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(){
        List<User> findResults = userRepository.findAll();
        return findResults.stream().findFirst().orElse(null);
    }
}
