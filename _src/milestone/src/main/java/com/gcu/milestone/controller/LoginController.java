package com.gcu.milestone.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.milestone.model.LoginModel;
import com.gcu.milestone.model.OrderModel;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

	 private static final Logger logger = Logger.getLogger(LoginController.class.getName());

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Login Form");
        model.addAttribute("loginModel", new LoginModel());
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Login Form");
            return "login";
        }

        List<OrderModel> orders = List.of(
            new OrderModel(0L, "0000000000", "Product 0", 0.00f, 0),
            new OrderModel(1L, "0000000001", "Product 1", 1.00f, 1),
            new OrderModel(2L, "0000000002", "Product 2", 2.00f, 2),
            new OrderModel(3L, "0000000003", "Product 3", 3.00f, 3),
            new OrderModel(4L, "0000000004", "Product 4", 4.00f, 4)
        );

        logger.info("User Logged In: Username=" + loginModel.getUsername() + ", Password=" + loginModel.getPassword());

        model.addAttribute("title", "My Dashboard");
        model.addAttribute("dashboard", orders);
        return "dashboard";
    }
}
