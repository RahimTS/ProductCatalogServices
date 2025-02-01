package rahim.learning.ProductCatalogServices.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rahim.learning.ProductCatalogServices.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
