package rahim.learning.ProductCatalogServices.services;


import rahim.learning.ProductCatalogServices.models.Product;

public interface IProductService {
     Product getProductById(Long productId);
}
