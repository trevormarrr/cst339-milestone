package com.gcu.milestone.data;

import com.gcu.milestone.model.ProductModel;

public interface ProductDAO extends DataAccessInterface<ProductModel> {
    // retrieve product by title
    ProductModel findByTitle(String title);
}
