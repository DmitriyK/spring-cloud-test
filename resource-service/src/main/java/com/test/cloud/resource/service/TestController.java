package com.test.cloud.resource.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Controller
public class TestController {

    //@PreAuthorize("#oauth2.hasScope('read_users')")
    @GetMapping("/login")
    public String test(/*@RequestHeader(value = "Authorization") String authorizationHeader,
                        Principal currentUser*/) {
        return "login";
    }
}
