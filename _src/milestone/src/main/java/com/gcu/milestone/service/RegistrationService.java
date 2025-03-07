package com.gcu.milestone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.milestone.data.DataAccessInterface;
import com.gcu.milestone.model.RegistrationModel;

@Service
public class RegistrationService {
    
    @Autowired
    private DataAccessInterface<RegistrationModel> userDAO;

    public boolean registerUser(RegistrationModel user) {
        if (userDAO.findByUsername(user.getUsername()) != null) {
            return false;
        }
        return userDAO.create(user);
    }

    public RegistrationModel findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public List<RegistrationModel> getAllUsers() {
        return userDAO.findAll();
    }

    public boolean updateUser(RegistrationModel user) {
        return userDAO.update(user);
    }

    public boolean deleteUser(RegistrationModel user) {
        return userDAO.delete(user);
    }
}
