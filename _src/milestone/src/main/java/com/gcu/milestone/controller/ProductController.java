package com.gcu.milestone.controller;

import com.gcu.milestone.model.ProductModel;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/create-product")
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());


    
   @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Create Product");
        model.addAttribute("productModel", new ProductModel());
        return "create-product";
    }

    @PostMapping("/doCreate")
    public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Product"); // title to registration
            return "create-product"; // if register fail, remain in page
        }

        // Simulating successful registration
        // display success page
        model.addAttribute("message", "product creation successful!");
        logger.info("User Created Product: Name=" + productModel.getName());
        return "create-product";
    }
}
