package com.demo.microservice.portfolioservice.repository;

import com.demo.microservice.portfolioservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
