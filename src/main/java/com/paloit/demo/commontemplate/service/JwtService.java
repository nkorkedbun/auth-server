package com.paloit.demo.commontemplate.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    
    String extractEmail(String token);

    String generateToken(UserDetails userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
