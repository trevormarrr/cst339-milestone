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
@RequestMapping("/create-book")
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Create Book");
        model.addAttribute("productModel", new ProductModel());
        return "create-product";
    }

    @PostMapping("/doCreate")
    public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Book"); // title to creation
            return "create-product"; // if creation fails, remain on page
        }

        // Simulating successful book creation
        model.addAttribute("message", "Book creation successful!");
        logger.info("Book Created: Title=" + productModel.getTitle() + ", Author=" + productModel.getAuthor());
        return "create-product";
    }
}
