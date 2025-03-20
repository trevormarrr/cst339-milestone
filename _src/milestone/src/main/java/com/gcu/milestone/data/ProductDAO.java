package com.gcu.milestone.data;

import com.gcu.milestone.model.ProductModel;

/*
 * Interface for product DAO
 * extends DataAccessInterface to provide CRUD operations for ProductModel
 */
public interface ProductDAO extends DataAccessInterface<ProductModel> {
    // retrieve product by title
    ProductModel findByTitle(String title);
}
