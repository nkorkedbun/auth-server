package com.paloit.demo.commontemplate.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.paloit.demo.commontemplate.entity.UserEntity;
import com.paloit.demo.commontemplate.model.request.SignInRequest;
import com.paloit.demo.commontemplate.model.request.SignUpRequest;
import com.paloit.demo.commontemplate.model.response.SignInResponse;
import com.paloit.demo.commontemplate.repository.UserRepository;
import com.paloit.demo.commontemplate.service.AuthService;
import com.paloit.demo.commontemplate.service.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public void signup(SignUpRequest request) {
        UserEntity userEntity = request.toUserEntity();
        userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public SignInResponse signin(SignInRequest request) {
        UserEntity userEntity = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        String accessToken = jwtService.generateToken(userEntity);
        return SignInResponse.builder()
                .accessToken(accessToken)
                .refreshToken("xxxxxxxxxxxx")
                .build();
    }
}
