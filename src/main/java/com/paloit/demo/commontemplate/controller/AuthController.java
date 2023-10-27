package com.paloit.demo.commontemplate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paloit.demo.commontemplate.model.request.SignInRequest;
import com.paloit.demo.commontemplate.model.request.SignUpRequest;
import com.paloit.demo.commontemplate.model.response.SignInResponse;
import com.paloit.demo.commontemplate.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth/")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public void signup(@Valid @RequestBody SignUpRequest request) {
        authService.signup(request);
    }

    @PostMapping("/signin")
    public SignInResponse signin(@Valid @RequestBody SignInRequest request) {
        return authService.signin(request);
    }
}
