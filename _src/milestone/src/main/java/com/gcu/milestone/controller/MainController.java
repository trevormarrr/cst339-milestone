package com.gcu.milestone.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.milestone.model.LoginModel;

/**
 * Handles routing for home, dashboard, & inventory pages
 */
@Controller
@RequestMapping("/")
public class MainController {
    /**
     * home page
     * 
     * @param model passes data to view
     * @return index/home page view
     */
    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Home Page");
        return "index";
    }

    /**
     * dashboard page
     * 
     * @param model passes data to view
     * @return dashboard page view
     */
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

    /**
     * inventory page
     * 
     * @param model passes data to view
     * @return inventory page view
     */
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
