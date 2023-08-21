package com.demo.microservice.portfolioservice.repository;

import com.demo.microservice.portfolioservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
