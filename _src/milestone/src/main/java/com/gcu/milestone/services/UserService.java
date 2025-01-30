package com.gcu.milestone.services;

import com.gcu.milestone.models.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();  // Temporary in-memory list (Replace with database in Milestone 4)

    // Constructor that adds default users
    public UserService() {
        // Add some default users for testing
        users.add(new User("trevor", "trevor", "Trevor", "Marr", "trevor@example.com", "1234567890"));
        users.add(new User("ashley", "ashley", "Ashley", "Barron", "ashley@example.com", "0987654321"));
    }


    public User findByUsername(String username) {
        // Lookup user by username (case insensitive)
        return users.stream()
                    .filter(user -> user.getUsername().equalsIgnoreCase(username))
                    .findFirst()
                    .orElse(null);  // Return null if user not found
    }

    public void save(User user) {
        // Save the user to the list (for registration)
        users.add(user);
    }
}