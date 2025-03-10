package com.gcu.milestone.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.milestone.data.ProductDAO;
import com.gcu.milestone.model.ProductModel;

@Service
public class ProductService {

    @Autowired
    private ProductDAO productDAO;

    // create new product
    public boolean createProduct(ProductModel product) {
        if (productDAO.findByTitle(product.getTitle()) != null) {
            return false; // false if product exists
        }
        return productDAO.create(product); // create new prodcut in db if product doesn't exist
    }

    // retrieve all products from db
    public List<ProductModel> getAllProducts() {
        return productDAO.findAll();
    }

    // retrieve product by id
    public ProductModel getProductById(int id) {
        return productDAO.findById(id);
    }

    // update existing product in db
    public boolean updateProduct(ProductModel product) {
        return productDAO.update(product);
    }

    // delete existing product in db
    public boolean deleteProduct(ProductModel product) {
        return productDAO.delete(product);
    }
}
