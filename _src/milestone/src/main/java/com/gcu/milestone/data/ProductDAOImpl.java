package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.milestone.data.mapper.ProductMapper;
import com.gcu.milestone.model.ProductModel;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private JdbcTemplate jdbcTemplate;

    // constructor
    // initiaalizes JdbcTemplate with data source
    @Autowired
    public ProductDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // retrieves all products from db
    @Override
    public List<ProductModel> findAll() {
        String sql = "SELECT * FROM products";
        try {
            return jdbcTemplate.query(sql, new ProductMapper());
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // retrieves product by id from db
    @Override
    public ProductModel findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
        } catch (Exception e) {
            return null;
        }
    }

    // creates new product in db
    @Override
    public boolean create(ProductModel product) {
        String sql = "INSERT INTO products (title, genre, author, year, checked_out) VALUES (?, ?, ?, ?, ?)";
        try {
            int rows = jdbcTemplate.update(sql,
                    product.getTitle(),
                    product.getGenre(),
                    product.getAuthor(),
                    product.getYear(),
                    product.getCheckedOut());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // updates existing product in db
    @Override
    public boolean update(ProductModel product) {
        String sql = "UPDATE products SET genre = ?, author = ?, year = ?, checked_out = ? WHERE title = ?";
        try {
            int rows = jdbcTemplate.update(sql,
                    product.getGenre(),
                    product.getAuthor(),
                    product.getYear(),
                    product.getCheckedOut(),
                    product.getTitle());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // deletes product from db by title
    @Override
    public boolean delete(ProductModel product) {
        String sql = "DELETE FROM products WHERE title = ?";
        try {
            int rows = jdbcTemplate.update(sql, product.getTitle());
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // retrieves product by title
    @Override
    public ProductModel findByTitle(String title) {
        String sql = "SELECT * FROM products WHERE title = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ProductMapper(), title);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ProductModel findByUsername(String username) {
        // Not applicable for products
        return null;
    }
}
