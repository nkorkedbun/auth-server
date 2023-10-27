package com.paloit.demo.commontemplate.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignInRequest {
    
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    private String password;
}
