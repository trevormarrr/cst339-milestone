package com.gcu.milestone.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.milestone.model.ProductModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Maps database rows to ProductModel objects
 */
public class ProductMapper implements RowMapper<ProductModel> {
    /**
     * Default constructor for ProductMapper
     */
    public ProductMapper() {
    }

    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        // create new product model object
        ProductModel product = new ProductModel();
        // set ProductModel properties
        product.setTitle(rs.getString("title"));
        product.setGenre(rs.getString("genre"));
        product.setAuthor(rs.getString("author"));
        product.setYear(rs.getInt("year"));
        product.setCheckedOut(rs.getBoolean("checked_out"));
        return product; // return populated ProductModel object
    }
}
