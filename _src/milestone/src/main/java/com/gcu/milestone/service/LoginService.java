package com.gcu.milestone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.milestone.repository.UserRepository;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Vervifies user login by checking username & password
     * 
     * @param username
     * @param password
     * @return true if user exists & if username & password match
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
