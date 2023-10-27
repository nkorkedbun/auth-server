package com.paloit.demo.commontemplate.model.request;

import com.paloit.demo.commontemplate.constant.Role;
import com.paloit.demo.commontemplate.entity.UserEntity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class SignUpRequest {
    
    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    @NotEmpty(message = "Password should not be empty")
    private String password;
    private Role role;

    public UserEntity toUserEntity(){
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(this.firstName);
        userEntity.setLastName(this.lastName);
        userEntity.setEmail(this.email);
        userEntity.setPassword(this.password);
        userEntity.setRole(this.role);
        return userEntity;
    }
}
