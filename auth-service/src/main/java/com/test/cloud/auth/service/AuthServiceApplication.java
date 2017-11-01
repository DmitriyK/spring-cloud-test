package com.test.cloud.auth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.security.Principal;

@RestController
@SpringBootApplication
@EnableAuthorizationServer
public class AuthServiceApplication {//extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }

    @GetMapping("/user")
    public String getUser2(Principal principal) {
        return principal.toString();
    }

    @PostMapping("/user")
    public String getUser(Principal principal) {
        return principal.toString();
    }
}
