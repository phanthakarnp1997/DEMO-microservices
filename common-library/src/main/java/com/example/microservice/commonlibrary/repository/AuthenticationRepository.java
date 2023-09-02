package com.example.microservice.commonlibrary.repository;

import com.example.microservice.commonlibrary.entity.AuthenticationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationEntity, Long> {
    Optional<AuthenticationEntity> findAuthenticationEntityByEmail(String email);
}
