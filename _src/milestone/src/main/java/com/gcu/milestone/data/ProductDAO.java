package com.gcu.milestone.data;

import com.gcu.milestone.model.ProductModel;

/**
 * Data Access Object interface for Product operations
 */
public interface ProductDAO extends DataAccessInterface<ProductModel> {
    /**
     * Finds a product by its title
     * @param title the title to search for
     * @return the found product or null if not found
     */
    ProductModel findByTitle(String title);
}
