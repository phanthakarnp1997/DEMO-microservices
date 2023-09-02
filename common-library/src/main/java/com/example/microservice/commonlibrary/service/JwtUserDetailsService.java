package com.example.microservice.commonlibrary.service;

import com.example.microservice.commonlibrary.entity.AuthenticationEntity;
import com.example.microservice.commonlibrary.exception.NotFoundException;
import com.example.microservice.commonlibrary.payload.jwt.JwtUserDetails;
import com.example.microservice.commonlibrary.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthenticationRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("USER"));

        AuthenticationEntity authenticationEntity = repository.findAuthenticationEntityByEmail(email).orElseThrow(() -> new NotFoundException("Email Not Found"));

        return new JwtUserDetails(authenticationEntity.getId(), authenticationEntity.getEmail(), authenticationEntity.getPassword(), roles);
    }
}
