package com.gcu.milestone.services;

import com.gcu.milestone.models.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();  // Temporary in-memory list (Replace with database in Milestone 4)

    public void saveUser(User user) {
        users.add(user);
        System.out.println("User saved: " + user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);
    }
}