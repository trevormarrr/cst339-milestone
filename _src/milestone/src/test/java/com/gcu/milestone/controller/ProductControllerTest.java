package com.gcu.milestone.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.gcu.milestone.model.ProductModel;
import com.gcu.milestone.service.ProductService;

/**
 * ProductController Unit Test
 */
@ExtendWith(SpringExtension.class)
public class ProductControllerTest {

        private MockMvc mockMvc;

        @Mock
        private ProductService productService;

        @InjectMocks
        private ProductController productController;

        /**
         * setup mockMvc environment
         */
        @BeforeEach
        void setUp() {
                MockitoAnnotations.openMocks(this);
                mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
        }

        /**
         * Test gets all products
         */
        @Test
        void testGetAllProducts() throws Exception {
                List<ProductModel> mockProducts = Arrays.asList(
                                new ProductModel("Book 1", "fantasy", "Author 1", 2005, true),
                                new ProductModel("Book 1", "fantasy", "Author 1", 2005, true));

                when(productService.getAllProducts()).thenReturn(mockProducts);

                mockMvc.perform(get("/products"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.size()", is(2)))
                                .andExpect(jsonPath("$[0].title", is("Product 1")));
        }

        /**
         * Test gets all products by id
         * 
         * @throws Exception
         */
        @Test
        void testGetProductById() throws Exception {
                ProductModel mockProduct = new ProductModel("Book 3", "fantasy", "Author 3", 2015, true);

                when(productService.getProductById(1)).thenReturn(mockProduct);

                mockMvc.perform(get("/products/1"))
                                .andExpect(status().isOk())
                                .andExpect(jsonPath("$.title", is("Test Product")));
        }

        /**
         * Test creates a new product
         */
        @Test
        void testCreateProduct() throws Exception {
                ProductModel newProduct = new ProductModel("Book 2", "mystery", "Author 2", 2002, true);

                when(productService.createProduct(any())).thenReturn(true);

                mockMvc.perform(post("/products")
                                .contentType("application/json")
                                .content(
                                                "{\"id\":1,\"title\":\"New Product\",\"description\":\"Description\",\"price\":20.0,\"quantity\":2}"))
                                .andExpect(status().isOk())
                                .andExpect(content().string("Product created successfully"));
        }

        /**
         * Test updates a new product
         */
        @Test
        void testUpdateProduct() throws Exception {
                ProductModel updatedProduct = new ProductModel("Book 1", "fantasy", "Author 1", 2005, true);

                when(productService.updateProduct(any())).thenReturn(true);

                mockMvc.perform(put("/products/1")
                                .contentType("application/json")
                                .content(
                                                "{\"id\":1,\"title\":\"Updated Product\",\"description\":\"New Desc\",\"price\":18.0,\"quantity\":5}"))
                                .andExpect(status().isOk())
                                .andExpect(content().string("Product updated successfully"));
        }

        /**
         * Test deletes a new product
         */
        @Test
        void testDeleteProduct() throws Exception {
                when(productService.deleteProduct(any())).thenReturn(true);

                mockMvc.perform(delete("/products/1"))
                                .andExpect(status().isOk())
                                .andExpect(content().string("Product deleted successfully"));
        }
}
