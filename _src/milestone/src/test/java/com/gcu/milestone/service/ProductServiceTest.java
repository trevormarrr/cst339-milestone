package com.gcu.milestone.service;

import com.gcu.milestone.data.ProductDAO;
import com.gcu.milestone.model.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * ProductService Unit Test
 */
public class ProductServiceTest {

    @Mock
    private ProductDAO productDAO;

    @InjectMocks
    private ProductService productService;

    /**
     * Starts Mockito before each test case
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests CreateProduct when product already exists
     */
    @Test
    void testCreateProduct_ProductExists_ReturnFalse() {
        ProductModel existingProduct = new ProductModel("Test Product", "Genre", "Author", 2021, true);

        // Mock productDAO to return an existing product when searching by title
        when(productDAO.findByTitle(existingProduct.getTitle())).thenReturn(existingProduct);

        // Call the method under test
        boolean result = productService.createProduct(existingProduct);

        // Validate the result
        assertFalse(result); // Should return false because the product already exists
    }

    /**
     * tests CreateProduct when product doesn't already exist
     */
    @Test
    void testCreateProduct_ProductDoesNotExist_ReturnTrue() {
        ProductModel newProduct = new ProductModel("New Product", "New Genre", "New Author", 2023, false);

        // Mock productDAO to return null when searching by title
        when(productDAO.findByTitle(newProduct.getTitle())).thenReturn(null);
        when(productDAO.create(newProduct)).thenReturn(true); // Simulate successful creation

        // Call the method under test
        boolean result = productService.createProduct(newProduct);

        // Validate the result
        assertTrue(result); // Should return true because the product doesn't exist
    }

    /**
     * tests GetAllProducts
     * return list with all products
     */
    @Test
    void testGetAllProducts() {
        List<ProductModel> mockProducts = Arrays.asList(
                new ProductModel("Product 1", "Genre 1", "Author 1", 2021, true),
                new ProductModel("Product 2", "Genre 2", "Author 2", 2022, false));

        // Mock productDAO to return the mock product list
        when(productDAO.findAll()).thenReturn(mockProducts);

        // Call the method under test
        List<ProductModel> result = productService.getAllProducts();

        // Validate the result
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Product 1", result.get(0).getTitle());
    }

    /**
     * Tests retrieving a product by id when it exists
     */
    @Test
    void testGetProductById_Found_ReturnsProduct() {
        ProductModel mockProduct = new ProductModel("Product 1", "Genre 1", "Author 1", 2021, true);

        // Mock productDAO to return the mock product when searching by id
        when(productDAO.findById(1)).thenReturn(mockProduct);

        // Call the method under test
        ProductModel result = productService.getProductById(1);

        // Validate the result
        assertNotNull(result);
        assertEquals("Product 1", result.getTitle());
    }

    /**
     * tests GetProductById when it doesn't exist
     */
    @Test
    void testGetProductById_NotFound_ReturnsNull() {
        // Mock productDAO to return null when searching by id
        when(productDAO.findById(999)).thenReturn(null);

        // Call the method under test
        ProductModel result = productService.getProductById(999);

        // Validate the result
        assertNull(result); // Should return null as the product is not found
    }

    /**
     * Tests UpdateProduct successful
     */
    @Test
    void testUpdateProduct_Success() {
        ProductModel updatedProduct = new ProductModel("Updated Product", "Updated Genre", "Updated Author", 2023,
                true);

        // Mock productDAO to simulate a successful update
        when(productDAO.update(updatedProduct)).thenReturn(true);

        // Call the method under test
        boolean result = productService.updateProduct(updatedProduct);

        // Validate the result
        assertTrue(result); // Should return true because the update was successful
    }

    /**
     * Tests DeleteProduct successful
     */
    @Test
    void testDeleteProduct_Success() {
        ProductModel productToDelete = new ProductModel("Product To Delete", "Genre", "Author", 2021, true);

        // Mock productDAO to simulate a successful deletion
        when(productDAO.delete(productToDelete)).thenReturn(true);

        // Call the method under test
        boolean result = productService.deleteProduct(productToDelete);

        // Validate the result
        assertTrue(result); // Should return true because the deletion was successful
    }

    /**
     * Tests DeleteProduct failure
     */
    @Test
    void testDeleteProduct_Failure() {
        ProductModel productToDelete = new ProductModel("Nonexistent Product", "Genre", "Author", 2021, true);

        // Mock productDAO to simulate a failed deletion
        when(productDAO.delete(productToDelete)).thenReturn(false);

        // Call the method under test
        boolean result = productService.deleteProduct(productToDelete);

        // Validate the result
        assertFalse(result); // Should return false because the deletion failed
    }
}
