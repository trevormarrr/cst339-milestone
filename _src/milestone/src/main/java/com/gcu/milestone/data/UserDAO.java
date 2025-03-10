package com.gcu.milestone.data;

import com.gcu.milestone.model.RegistrationModel;

public interface UserDAO {
    // creates new user record in db
    boolean create(RegistrationModel user);

    // Finds user by username
    RegistrationModel findByUsername(String username);

    // checks if user exists by username
    boolean exists(String username);
}
