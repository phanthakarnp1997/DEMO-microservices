package com.example.microservice.commonlibrary.payload.jwt;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class JwtUserDetails extends User {
    public final Long id;

    public JwtUserDetails(final Long id, final String username, final String hash,
                          final List<SimpleGrantedAuthority> authorities) {
        super(username, hash, authorities);
        this.id = id;
    }
}
