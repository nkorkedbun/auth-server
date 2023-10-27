package com.paloit.demo.commontemplate.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/demo")
public class DemoController {
    
    @GetMapping("/hello")
    public String hello(@RequestHeader(value = "Authorization") String accessToken){
        return "USER Hello World";
    }
    
    @GetMapping("/admin/hello")
    public String adminHello(@RequestHeader(value = "Authorization") String accessToken){
        return "ADMIN Hello World";
    }

    @GetMapping("/user/hello")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public String userHello(@RequestHeader(value = "Authorization") String accessToken){
        return "USER with annotation auth Hello World";
    }
}
