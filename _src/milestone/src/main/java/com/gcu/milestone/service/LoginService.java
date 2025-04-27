package com.gcu.milestone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.milestone.repository.UserRepository;

/**
 * Service class for handling user login operations
 */
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Verifies user login by checking username and password
     *
     * @param username the username to verify
     * @param password the password to verify
     * @return true if user exists and if username and password match
     */
    public boolean loginUser(String username, String password) {
        var user = userRepository.findByUsername(username);

        if (user != null) {
            // Verify password matches the hashed version
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }
}
