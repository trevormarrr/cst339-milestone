package com.gcu.milestone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.milestone.data.ProductDAO;
import com.gcu.milestone.model.ProductModel;

@Service
/**
 * Service class handling product business logic
 */
public class ProductService {

    /**
     * Spring bean: ProductService managed by Spring IoC
     * IoC: injects ProductDAO provided by spring
     */
    private final ProductDAO productDAO;

    /*
     * Constructor Injection
     * Ensures ProductDAO is provided by Spring
     */
    @Autowired
    /**
     * Constructor for ProductService
     * @param productDAO Data access object for products
     */
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * Creates a new product
     * @param product The product to create
     * @return true if creation was successful
     */
    public boolean createProduct(ProductModel product) {
        if (productDAO.findByTitle(product.getTitle()) != null) {
            return false; // false if product exists
        }
        return productDAO.create(product); // create new prodcut in db if product doesn't exist
    }

    /**
     * Retrieves all products
     * @return List of all products
     */
    public List<ProductModel> getAllProducts() {
        return productDAO.findAll();
    }

    /**
     * Retrieves a product by its ID
     * @param id The ID of the product
     * @return The found product or null
     */
    public ProductModel getProductById(int id) {
        return productDAO.findById(id);
    }

    /**
     * Updates an existing product
     * @param product The product to update
     * @return true if update was successful
     */
    public boolean updateProduct(ProductModel product) {
        return productDAO.update(product);
    }

    /**
     * Deletes a product
     * @param product The product to delete
     * @return true if deletion was successful
     */
    public boolean deleteProduct(ProductModel product) {
        return productDAO.delete(product);
    }

    /**
     * Finds a product by its title
     * @param title The title to search for
     * @return The found product or null
     */
    public ProductModel findByTitle(String title) {
        return productDAO.findByTitle(title);
    }
}
