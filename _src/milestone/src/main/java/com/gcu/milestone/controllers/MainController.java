package com.gcu.milestone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Welcome to My App");
        return "index";
    }

    // Controller for index section
    // Ashley did this section
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("title", "Home");
        return "index";

    }
}
