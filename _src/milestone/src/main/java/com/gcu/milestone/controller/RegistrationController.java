package com.gcu.milestone.controller;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.milestone.model.RegistrationModel;
import com.gcu.milestone.service.RegistrationService;

import jakarta.validation.Valid;

/**
 * user register
 */
@Controller
@RequestMapping("/register")
public class RegistrationController {
    private static final Logger logger = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    private RegistrationService registrationService; // autowire the service

    /**
     * Displays registration form
     * 
     * @param model passes data to view
     * @return register view page
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "User Registration");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }

    /**
     * Successful or unsuccessful registration
     * 
     * @param registrationModel user input from form
     * @param bindingResult     validation result
     * @param model             passes data to view
     * @return register result page or redirect
     */
    @PostMapping("/doRegister")
    public String doRegister(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model) {
        // Check for validation errors
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "User Registration");
            return "register";
        }

        try {
            // Attempt to register the user
            boolean isRegistered = registrationService.registerUser(registrationModel);

            if (isRegistered) {
                logger.info("User registered successfully: " + registrationModel.getUsername());
                model.addAttribute("message", "Registration successful! You can now log in.");
                // Optionally redirect to login page
                // return "redirect:/login/";
            } else {
                logger.warning("Registration failed for username: " + registrationModel.getUsername());
                model.addAttribute("message", "Registration failed. Username may already exist.");
            }
        } catch (Exception e) {
            logger.severe("Error during registration: " + e.getMessage());
            model.addAttribute("message", "An error occurred during registration. Please try again.");
        }

        return "register";
    }

    /**
     * Checks database connection by findinf test user
     * 
     * @param model passes test result
     * @return register view test message
     */
    @GetMapping("/test")
    public String testDatabase(Model model) {
        try {
            // Try to find test user
            RegistrationModel user = registrationService.findByUsername("testuser");
            if (user != null) {
                model.addAttribute("message", "Database connection successful! Found test user: " + user.getEmail());
            } else {
                model.addAttribute("message", "Database connected but test user not found");
            }
        } catch (Exception e) {
            model.addAttribute("message", "Database connection failed: " + e.getMessage());
        }
        return "register";
    }
}
