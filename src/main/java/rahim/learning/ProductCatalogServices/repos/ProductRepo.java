package rahim.learning.ProductCatalogServices.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rahim.learning.ProductCatalogServices.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {    
}
