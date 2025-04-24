package com.gcu.milestone.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    /**
     * Display user authenticated username & role
     * 
     * @return granted authorities
     */
    @GetMapping("/test/auth")
    public String testAuth() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Currently logged in user: " + auth.getName() +
                "\nRoles: " + auth.getAuthorities();
    }
}
