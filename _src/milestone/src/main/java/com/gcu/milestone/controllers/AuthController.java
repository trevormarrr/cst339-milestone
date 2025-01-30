package com.gcu.milestone.controllers;

import com.gcu.milestone.models.User;
import com.gcu.milestone.services.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }

        // Save user to the temporary list (Will be database in Milestone 4)
        userService.saveUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
public String processLogin(@ModelAttribute("username") String username, @ModelAttribute("password") String password, Model model) {
    User user = userService.findByUsername(username);
    
    if (user == null || !user.getPassword().equals(password)) {
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    return "redirect:/";
}

}