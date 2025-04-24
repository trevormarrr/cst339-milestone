package com.gcu.milestone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.gcu.milestone.data.DataAccessInterface;
import com.gcu.milestone.model.RegistrationModel;

/**
 * Service Layer - handles registration-related operations
 */
@Service
public class RegistrationService {

    @Autowired
    private DataAccessInterface<RegistrationModel> userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Reguster new user if username doesn't exist
     * 
     * @param user registration data for new user
     * @return true if success, else return false
     */
    public boolean registerUser(RegistrationModel user) {
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false;
        }
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.create(user);
    }

    /**
     * finds user by username
     * 
     * @param username username to search
     * @return username
     */
    public RegistrationModel findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    /**
     * retrieves all users
     * 
     * @return all users
     */
    public List<RegistrationModel> getAllUsers() {
        return userDAO.findAll();
    }

    /**
     * updates user info
     * 
     * @param user updated user data
     * @return true if updated is successful
     */
    public boolean updateUser(RegistrationModel user) {
        return userDAO.update(user);
    }

    /**
     * deletes user by username
     * 
     * @param user delete user data
     * @return true if delete was successful
     */
    public boolean deleteUser(RegistrationModel user) {
        return userDAO.delete(user);
    }
}
