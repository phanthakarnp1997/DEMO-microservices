package com.demo.microservice.portfolioservice.service;

import com.demo.microservice.portfolioservice.model.User;
import com.demo.microservice.portfolioservice.payload.request.UserRequest;
import com.demo.microservice.portfolioservice.repository.UserRepository;
import com.example.microservice.commonlibrary.exception.NotFoundException;
import com.example.microservice.commonlibrary.util.constant.ErrorCodes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User saveUser(UserRequest userRequest) {
        User userMapped = new User();
        modelMapper.map(userRequest, userMapped);
        userMapped.setHashPassword("hashed-password");
        userMapped.setLastLogin(new Date());
        return userRepository.save(userMapped);
    }

    public User updateUser(Long userId, UserRequest userRequest) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new NotFoundException(ErrorCodes.NOT_FOUND_BUSINESS_CODE_2, String.format("User Not Found %s", userId));
        }
        User userMapped = optionalUser.get();
        modelMapper.map(userRequest, userMapped);
        return userRepository.save(userMapped);
    }

    public boolean deleteUser(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteById(userId);
            return true;
        }
        return false;
    }
}
