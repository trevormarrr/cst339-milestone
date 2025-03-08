package com.gcu.milestone.repository; // Adjust the package name to match your project structure

import com.gcu.milestone.model.RegistrationModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<RegistrationModel, Integer> {
    // Custom query to find a user by username
    RegistrationModel findByUsername(String username);
}
