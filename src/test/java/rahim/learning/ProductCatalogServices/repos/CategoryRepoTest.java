package rahim.learning.ProductCatalogServices.repos;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import rahim.learning.ProductCatalogServices.models.Category;
import rahim.learning.ProductCatalogServices.models.Product;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CategoryRepoTest {

    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    void TestFetchTypes() {
        Category category = categoryRepo.findById(10L).get();
        for(Product product : category.getProducts()) {
            System.out.println(product);
        }
    }
}