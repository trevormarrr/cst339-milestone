package com.gcu.milestone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.milestone.model.RegistrationModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

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

        // Simulating successful registration
        // display success page
        model.addAttribute("message", "Registration successful! You can now log in.");
        return "register";
    }
}
