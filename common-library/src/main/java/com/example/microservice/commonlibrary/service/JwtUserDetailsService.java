package com.example.microservice.commonlibrary.service;

import com.example.microservice.commonlibrary.payload.jwt.JwtUserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final List<SimpleGrantedAuthority> roles = Collections.singletonList(new SimpleGrantedAuthority("USER_ROLE"));
        return new JwtUserDetails(1L, username, "$2a$10$xSUWQi1LFz4MnsIpzp3QNOz1WgU1hA7/oTlUp43FdQ8Z9YpBEc3sK", roles);
    }
}
