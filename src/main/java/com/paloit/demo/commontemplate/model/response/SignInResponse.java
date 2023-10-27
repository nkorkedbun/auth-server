package com.paloit.demo.commontemplate.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInResponse {
    
    private String accessToken;
    private String refreshToken;
}
