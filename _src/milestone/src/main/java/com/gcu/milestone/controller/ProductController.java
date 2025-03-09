package com.gcu.milestone.controller;

import com.gcu.milestone.model.ProductModel;
import com.gcu.milestone.service.ProductService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String display(Model model) {
        model.addAttribute("title", "Create Book");
        model.addAttribute("productModel", new ProductModel());
        return "create-product";
    }

    @PostMapping("/doCreate")
    public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Book");
            return "create-product";
        }

        try {
            boolean created = productService.createProduct(productModel);
            if (created) {
                model.addAttribute("message", "Book creation successful!");
                logger.info("Book Created: Title=" + productModel.getTitle() + ", Author=" + productModel.getAuthor());
            } else {
                model.addAttribute("message", "Book creation failed. Title may already exist.");
            }
        } catch (Exception e) {
            model.addAttribute("message", "An error occurred while creating the book.");
            logger.severe("Error creating book: " + e.getMessage());
        }

        return "create-product";
    }
}
