package rahim.learning.ProductCatalogServices.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import rahim.learning.ProductCatalogServices.dtos.ProductDto;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.services.IProductService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController controller;

    @MockBean
    private IProductService service;

    @Test
    public void Test_getProductById_ReturnsProduct() {
        //Arrange
        Long productId = 1L;
        Product product = new Product();
        product.setId(productId);
        product.setName("iPhone");
        when(service.getProductById(productId)).thenReturn(product);

        //Act
        ResponseEntity<ProductDto> response = controller.findProductById(productId);

        //Assert
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(productId, response.getBody().getId());
        assertEquals("iPhone", response.getBody().getName());
        verify(service,times(1)).getProductById(productId);
    }

    @Test
    public void test_getProductById_calledWith_InvalidId_resultsInIllegalArgumentException() {

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            controller.findProductById(-1L);
        });
        assertEquals("Please try with productId > 0", exception.getMessage());
    }

}