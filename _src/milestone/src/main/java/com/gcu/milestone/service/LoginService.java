package com.gcu.milestone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository; // Injecting UserRepository to interact with the database

    public boolean loginUser(String username, String password) {
        // Attempt to find the user by their username
        var user = userRepository.findByUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            // If user exists and passwords match
            return true;
        } else {
            // If no user found or passwords don't match
            return false;
        }
    }
}
