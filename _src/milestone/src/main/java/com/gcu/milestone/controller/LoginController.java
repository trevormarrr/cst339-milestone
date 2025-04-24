package com.gcu.milestone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * Display form for User login
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    /**
     * Handles GETrequest
     * 
     * @param model passes data to view
     * @return login view page
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        return "login";
    }
}
