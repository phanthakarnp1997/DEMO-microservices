package com.demo.microservice.portfolioservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "User")
public class User {
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "lastlogin")
    private Date lastLogin;

    @Column(name = "aboutme")
    private String aboutMe;
}
