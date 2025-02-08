package rahim.learning.ProductCatalogServices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import rahim.learning.ProductCatalogServices.dtos.CategoryDto;
import rahim.learning.ProductCatalogServices.dtos.ProductDto;
import rahim.learning.ProductCatalogServices.models.Category;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.services.IProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

/*    @Qualifier("fkps")
    @Autowired
    private IProductService productService1;*/

    //@Qualifier("sps")
    @Autowired
    private IProductService productService2;

    // Retrieve all products
    @GetMapping
    public List<ProductDto> getAllProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        List<Product> products = productService2.getAllProducts();
        for (Product product : products) {
            productDtos.add(from(product));
        }
        return productDtos;
    }

    // Retrieve a product by its ID
    @GetMapping("{productId}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long productId) {
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

            if (productId <= 0) {
                headers.add("called by", "rahim");
                throw new IllegalArgumentException("Please try with productId > 0");
            }

            Product product = productService2.getProductById(productId);
            headers.add("called by", "intelligent");
            if (product == null) {
                return new ResponseEntity<>(null, headers, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(from(product), headers, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            throw exception;
        }
    }

    // Create a new product
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        Product inputProduct = from(productDto);
        Product savedProduct = productService2.save(inputProduct);
        return new ResponseEntity<>(from(savedProduct), HttpStatus.CREATED);
    }

    // Update an existing product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> replaceProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        Product productRequest = from(productDto);
        Product updatedProduct = productService2.replaceProduct(id, productRequest);
        return new ResponseEntity<>(from(updatedProduct), HttpStatus.OK);
    }

    @GetMapping("{pid}/{uid}")
    public ProductDto getProductDetailsBasedOnUser(@PathVariable Long pid, @PathVariable Long uid) {
        Product product = productService2.getProductBasedOnUser(pid, uid);
        if (product == null) return null;
        return from(product);
    }

    // Convert ProductDto to Product
    private Product from(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageUrl());
        product.setDescription(productDto.getDescription());

        if (productDto.getCategory() != null) {
            Category category = new Category();
            category.setId(productDto.getCategory().getId());
            category.setName(productDto.getCategory().getName());
            product.setCategory(category);
        }
        return product;
    }

    // Convert Product to ProductDto
    private ProductDto from(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setImageUrl(product.getImageUrl());

        if (product.getCategory() != null) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(product.getCategory().getId());
            categoryDto.setName(product.getCategory().getName());
            categoryDto.setDescription(product.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;
    }
}
