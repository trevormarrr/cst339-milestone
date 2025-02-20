package com.gcu.milestone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.milestone.model.LoginModel;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Home Page");
        return "index";
    }

    @GetMapping("dashboard")
    public String displayDashboard(Model model) {
        model.addAttribute("title", "My Dashboard"); // title to dashpage

        // Ensure loginModel is set
        // checks if loginmodel data is available for dashboard
        if (!model.containsAttribute("loginModel")) {
            model.addAttribute("loginModel", new LoginModel()); // Use an appropriate default object
        }

        return "dashboard";
    }

    @GetMapping("inventory")
    public String displayInventory(Model model) {
        model.addAttribute("title", "My Inventory"); // title to dashpage

        // Ensure loginModel is set
        // checks if loginmodel data is available for dashboard
        if (!model.containsAttribute("loginModel")) {
            model.addAttribute("loginModel", new LoginModel()); // Use an appropriate default object
        }

        return "inventory";
    }

}
