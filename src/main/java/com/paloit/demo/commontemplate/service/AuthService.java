package com.paloit.demo.commontemplate.service;

import com.paloit.demo.commontemplate.model.request.SignUpRequest;
import com.paloit.demo.commontemplate.model.request.SignInRequest;
import com.paloit.demo.commontemplate.model.response.SignInResponse;

public interface AuthService {
    
    void signup(SignUpRequest request);

    SignInResponse signin(SignInRequest request);
}
