package com.gcu.milestone.controller;

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

@Controller
@RequestMapping("/register")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService; // autowire the service

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "User Registration");
        model.addAttribute("registrationModel", new RegistrationModel());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@Valid RegistrationModel registrationModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "User Registration"); // title to registration
            return "register"; // if register fail, remain in page
        }

        boolean isRegistered = registrationService.registerUser(registrationModel);

        if (isRegistered) {
            // Simulating successful registration
            // display success page
            model.addAttribute("message", "Registration successful! :D You can now log in.");
        } else {
            model.addAttribute("message", "Registration unsuccessful :(");
        }

        return "register";
    }
}
