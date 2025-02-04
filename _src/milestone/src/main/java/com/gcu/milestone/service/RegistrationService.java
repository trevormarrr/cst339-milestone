package com.gcu.milestone.service;

import com.gcu.milestone.model.RegistrationModel;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    public boolean registerUser(RegistrationModel user) {
        // Simulating database storage with a placeholder
        // Future milestone: Store in a real database
        System.out.println("User registered: " + user.getUsername());
        return true;
    }
}
