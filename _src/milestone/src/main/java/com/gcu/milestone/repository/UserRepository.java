package com.gcu.milestone.repository;

import com.gcu.milestone.model.RegistrationModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for User entity operations
 * Provides CRUD operations for the RegistrationModel entity
 */
public interface UserRepository extends JpaRepository<RegistrationModel, Long> {
    /**
     * finds user by usernme
     * 
     * @param username username to search
     * @return username
     */
    RegistrationModel findByUsername(String username);
}
