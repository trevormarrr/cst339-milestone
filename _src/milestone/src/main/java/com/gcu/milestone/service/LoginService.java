package com.gcu.milestone.service;

import org.springframework.stereotype.Service;

import com.gcu.milestone.model.LoginModel;

// Service for the login
@Service // spring bean
public class LoginService {
    public boolean loginUser(LoginModel user) {

        if ("username".equals(user.getUsername()) && "passwprd".equals(user.getPassword())) {
            System.out.println("User logged in: " + user);
            return true;
        }
        return false;

    }
}
