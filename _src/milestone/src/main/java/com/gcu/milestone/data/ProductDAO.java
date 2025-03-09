package com.gcu.milestone.data;

import com.gcu.milestone.model.ProductModel;

public interface ProductDAO extends DataAccessInterface<ProductModel> {
    ProductModel findByTitle(String title);
}
