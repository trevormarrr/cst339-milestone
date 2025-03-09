package com.gcu.milestone.data.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.gcu.milestone.model.ProductModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel> {
    @Override
    public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductModel product = new ProductModel();
        product.setTitle(rs.getString("title"));
        product.setGenre(rs.getString("genre"));
        product.setAuthor(rs.getString("author"));
        product.setYear(rs.getInt("year"));
        product.setCheckedOut(rs.getBoolean("checked_out"));
        return product;
    }
}
