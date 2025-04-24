package com.gcu.milestone.data;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import com.gcu.milestone.data.mapper.ProductMapper;
import com.gcu.milestone.model.ProductModel;

/**
 * ProductDAOImpl Unit Test
 */
public class ProductDAOImplTest {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private ProductDAOImpl productDAO;

    /**
     * Starts Mockito before each test case
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests testFindByTitle method to ensureit correctly returns product
     */
    @Test
    void testFindByTitle() {
        ProductModel mockProduct = new ProductModel("Test Product", "Genre", "Author", 2021, true);

        // Mock the JdbcTemplate behavior
        when(jdbcTemplate.queryForObject(anyString(), any(Object[].class), any(ProductMapper.class)))
                .thenReturn(mockProduct);

        // Call the method under test
        ProductModel result = productDAO.findByTitle("Test Product");

        // Validate the result
        assertNotNull(result);
        assertEquals("Test Product", result.getTitle());
        assertEquals("Genre", result.getGenre());
    }

    /**
     * Tests the FindAll metho to ensure it retrieves all products from db
     */
    @Test
    void testFindAll() {
        List<ProductModel> mockProducts = Arrays.asList(
                new ProductModel("Product 1", "Genre 1", "Author 1", 2021, true),
                new ProductModel("Product 2", "Genre 2", "Author 2", 2022, false));

        // Mock the JdbcTemplate behavior
        when(jdbcTemplate.query(anyString(), any(ProductMapper.class)))
                .thenReturn(mockProducts);

        // Call the method under test
        List<ProductModel> result = productDAO.findAll();

        // Validate the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    /**
     * Tests CreateProduct to ensure a product can be added to db
     */
    @Test
    void testCreateProduct() {
        ProductModel newProduct = new ProductModel("New Product", "New Genre", "New Author", 2023, false);

        // Mock the JdbcTemplate behavior to simulate a successful insert
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any()))
                .thenReturn(1); // Simulate that 1 row was affected by the insert

        // Call the method under test
        boolean result = productDAO.create(newProduct);

        // Validate the result
        assertTrue(result);
    }

    /**
     * Tests UpdateProduct to ensure a product can be updated/edited
     */
    @Test
    void testUpdateProduct() {
        ProductModel updatedProduct = new ProductModel("Updated Product", "Updated Genre", "Updated Author", 2023,
                true);

        // Mock the JdbcTemplate behavior to simulate a successful update
        when(jdbcTemplate.update(anyString(), any(), any(), any(), any(), any()))
                .thenReturn(1); // Simulate that 1 row was affected by the update

        // Call the method under test
        boolean result = productDAO.update(updatedProduct);

        // Validate the result
        assertTrue(result);
    }

    /**
     * Tests DeleteProduct to ensure a product can be deleted
     */
    @Test
    void testDeleteProduct() {
        ProductModel productToDelete = new ProductModel("Product To Delete", "Genre", "Author", 2021, true);

        // Call the method under test
        boolean result = productDAO.delete(productToDelete);

        // Validate the result
        assertTrue(result);
    }
}
