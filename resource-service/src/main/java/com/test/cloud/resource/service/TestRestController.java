package com.test.cloud.resource.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestRestController {

    @PreAuthorize("#oauth2.hasScope('write_users')")
    @PostMapping("/user2")
    public String test(@RequestHeader(value = "Authorization") String authorizationHeader,
                       Principal currentUser) {
        return "hell";
    }

    @PreAuthorize("#oauth2.hasScope('read_users')")
    @GetMapping("/user")
    public String test2(@RequestHeader(value = "Authorization") String authorizationHeader,
                        Principal currentUser) {
        return "hell";
    }
}
