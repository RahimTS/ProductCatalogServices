package rahim.learning.ProductCatalogServices.services;


import java.util.List;

import rahim.learning.ProductCatalogServices.models.Product;

public interface IProductService {
     Product getProductById(Long productId);
     List<Product> getAllProducts();
     Product replaceProduct(Long productId, Product request);
     Product save(Product product);
     Product getProductBasedOnUser(Long productId, Long userId);
}
