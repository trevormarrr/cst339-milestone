package com.gcu.milestone.data;

import com.gcu.milestone.model.RegistrationModel;

/**
 * Data Access Object interface for User operations
 */
public interface UserDAO {
    /**
     * Creates a new user
     * @param user the user to create
     * @return true if creation was successful
     */
    boolean create(RegistrationModel user);

    /**
     * Finds a user by their username
     * @param username the username to search for
     * @return the found user or null if not found
     */
    RegistrationModel findByUsername(String username);

    /**
     * Checks if a username already exists
     * @param username the username to check
     * @return true if the username exists
     */
    boolean exists(String username);
}
