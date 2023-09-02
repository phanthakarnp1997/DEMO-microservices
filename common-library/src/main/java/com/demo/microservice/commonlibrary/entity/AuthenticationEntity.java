package com.demo.microservice.commonlibrary.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "User")
public class AuthenticationEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "hash_password")
    private String password;
}
