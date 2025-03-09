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

    public boolean createProduct(ProductModel product) {
        if (productDAO.findByTitle(product.getTitle()) != null) {
            return false;
        }
        return productDAO.create(product);
    }

    public List<ProductModel> getAllProducts() {
        return productDAO.findAll();
    }

    public ProductModel getProductById(int id) {
        return productDAO.findById(id);
    }

    public boolean updateProduct(ProductModel product) {
        return productDAO.update(product);
    }

    public boolean deleteProduct(ProductModel product) {
        return productDAO.delete(product);
    }
}
