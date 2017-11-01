package com.test.cloud.auth.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

//@RestController
@SpringBootApplication
//@EnableResourceServer
public class AuthServiceSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceSimpleApplication.class, args);
    }

    /*@GetMapping("/user")
    public Principal getUser2(Principal principal) {
        return principal;
    }

    @PostMapping("/user")
    public Principal getUser(Principal principal) {
        return principal;
    }*/
}
