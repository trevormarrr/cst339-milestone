package com.gcu.milestone.controller;

import com.gcu.milestone.model.ProductModel;
import com.gcu.milestone.service.ProductService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@Controller
/**
 * CRUD operations for products
 */
public class ProductController {
    private static final Logger logger = Logger.getLogger(ProductController.class.getName());

    @Autowired
    private ProductService productService;

    /**
     * Display all products
     * 
     * @param model passes data to view
     * @return products page view
     */
    @GetMapping("/products")
    public String displayProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    /**
     * Display create form
     * 
     * @param model passes data to view
     * @return create-product view
     */
    @GetMapping("/create-book/")
    public String display(Model model) {
        model.addAttribute("title", "Create Book");
        model.addAttribute("productModel", new ProductModel());
        return "create-product";
    }

    /**
     * Handles product creation
     * @param productModel the product model containing the data
     * @param bindingResult validation results
     * @param model the Spring MVC model
     * @return the view name to render
     */
    @PostMapping("/create-book/doCreate")
    public String doCreate(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("title", "Create Book");
            return "create-product";
        }

        try {
            boolean created = productService.createProduct(productModel);
            if (created) {
                return "redirect:/products?success=created";
            } else {
                model.addAttribute("message", "Book creation failed. Title may already exist.");
            }
        } catch (Exception e) {
            logger.severe("Error creating book: " + e.getMessage());
            model.addAttribute("message", "An error occurred while creating the book.");
        }
        return "create-product";
    }

    /**
     * Display edit form
     * 
     * @param title title of product to edit
     * @param model passes data to view
     * @return edit-product view or redirect if not found
     */
    @GetMapping("/products/edit/{title}")
    public String displayEdit(@PathVariable String title, Model model) {
        ProductModel product = productService.findByTitle(title);
        if (product == null) {
            return "redirect:/products?error=notfound";
        }
        model.addAttribute("product", product);
        return "edit-product";
    }

    /**
     * Handle update submission
     * 
     * @param product       updated product data
     * @param bindingResult result of validation
     * @return reidrect to list
     */
    @PostMapping("/products/update")
    public String updateProduct(@Valid ProductModel product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-product";
        }

        if (productService.updateProduct(product)) {
            return "redirect:/products?success=updated";
        }
        return "redirect:/products?error=updatefailed";
    }

    /**
     * Handles delete
     * 
     * @param title title of product to delete
     * @return redirect to products list
     */
    @PostMapping("/products/delete")
    public String deleteProduct(@RequestParam String title) {
        ProductModel product = productService.findByTitle(title);
        if (product != null && productService.deleteProduct(product)) {
            return "redirect:/products?success=deleted";
        }
        return "redirect:/products?error=deletefailed";
    }
}
