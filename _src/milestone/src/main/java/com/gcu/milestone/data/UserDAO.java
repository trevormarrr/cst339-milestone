package com.gcu.milestone.data;

import com.gcu.milestone.model.RegistrationModel;

public interface UserDAO {
    boolean create(RegistrationModel user);
    RegistrationModel findByUsername(String username);
    boolean exists(String username);
}
