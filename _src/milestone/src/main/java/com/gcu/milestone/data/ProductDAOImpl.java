package com.gcu.milestone.data;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.gcu.milestone.data.mapper.ProductMapper;
import com.gcu.milestone.model.ProductModel;

import java.util.logging.Level;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private static final Logger logger = Logger.getLogger(ProductDAOImpl.class.getName());
    private final JdbcTemplate jdbcTemplate;

    // constructor
    // initializes JdbcTemplate with data source
    @Autowired
    public ProductDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /*
     * retrieves all products from db
     * 
     * @return List of ProductModel objects
     */
    @Override
    public List<ProductModel> findAll() {
        String sql = "SELECT * FROM products";
        try {
            return jdbcTemplate.query(sql, new ProductMapper());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error retrieving product", e);
            return new ArrayList<>();
        }
    }

    /*
     * retrieves product by id from db
     * 
     * @param id The product id
     * 
     * @return ProductModel if not found else remain null
     */
    @Override
    public ProductModel findById(int id) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ProductMapper(), id);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Product not found by ID: " + id, e);
            return null;
        }
    }

    /*
     * creates new product in db
     * 
     * @param product
     * The product to add
     * 
     * @return true if successful, else return false
     */
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
            logger.log(Level.SEVERE, "Error creating product", e);
            return false;
        }
    }

    /*
     * updates existing product in db
     * 
     * @param product
     * updated product details
     * 
     * @return true if successful, else return false
     */
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
            logger.log(Level.SEVERE, "Error updating product", e);
            return false;
        }
    }

    /*
     * deletes product from db by title
     * 
     * @param product
     * Product to delete
     * 
     * @return true if successful, else return false
     */
    @Override
    public boolean delete(ProductModel product) {
        String sql = "DELETE FROM products WHERE title = ?";
        try {
            int rows = jdbcTemplate.update(sql, product.getTitle());
            return rows > 0;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error deleting product", e);
            return false;
        }
    }

    /*
     * retrieves product by title
     * 
     * @param title
     * product title
     * 
     * @return ProductModeil if not found, else return null
     */
    @Override
    public ProductModel findByTitle(String title) {
        String sql = "SELECT * FROM products WHERE title = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new ProductMapper(), title);
        } catch (Exception e) {
            logger.log(Level.WARNING, "Product not found by title", e);
            return null;
        }
    }

    /*
     * placeholder method for findByUsername
     * 
     * @param username
     * username (unused)
     * 
     * @return null
     */
    //
    @Override
    public ProductModel findByUsername(String username) {
        // Not applicable for products
        return null;
    }
}
