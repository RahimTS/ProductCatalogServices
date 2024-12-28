package rahim.learning.ProductCatalogServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahim.learning.ProductCatalogServices.dtos.CategoryDto;
import rahim.learning.ProductCatalogServices.dtos.ProductDto;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.services.IProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        Product product = new Product();
        product.setId(2L);
        product.setName("Iphone");
        List<Product> products = new ArrayList<>();
        products.add(product);
        return  products;
    }


    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId) {
        if(productId <= 0) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

      Product product = productService.getProductById(productId);
      if(product == null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
      return new ResponseEntity<>(from(product),HttpStatus.OK);
    }

    private ProductDto from (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product .getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());
        if(product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return product;
    }

}
