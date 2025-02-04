package com.gcu.milestone.controllers;

import com.gcu.milestone.models.User;
import com.gcu.milestone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    // Display the login page
    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // This should map to the Thymeleaf login template
    }

    // Handle the login form submission
    @PostMapping("/login")
    public String handleLogin(@Valid User user, BindingResult result, Model model) {
        // Try to find the user by username
        User existingUser = userService.findByUsername(user.getUsername());

        // If the user doesn't exist or the password doesn't match
        if (existingUser == null || !existingUser.getPassword().equals(user.getPassword())) {
            // If invalid credentials, add an error message and return to the login page
            result.rejectValue("username", "error.user", "Invalid credentials");
            return "login";
        }

        // If login is successful, add the user object to the model and redirect to the
        // home page
        model.addAttribute("user", existingUser);
        return "index"; // The page to redirect to after a successful login
    }

    // Display the registration page (if needed)
    @GetMapping("/register")
    public String showRegistrationPage() {
        return "register"; // This should map to the Thymeleaf registration template
    }

    // Handle the registration form submission (this will be added in the future)
    @PostMapping("/register")
    public String handleRegistration(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register"; // Return to the registration page if validation fails
        }
        // Implement logic for saving the user data (e.g., save to a database)
        userService.save(user);
        return "login"; // Redirect to login after successful registration
    }
}