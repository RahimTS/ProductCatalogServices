package rahim.learning.ProductCatalogServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rahim.learning.ProductCatalogServices.dtos.UserDto;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.repos.ProductRepo;

import java.util.List;
import java.util.Optional;


@Service("sps")
@Primary
public class StorageProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepo.findProductById(productId);
        if (productOptional.isEmpty()) return null;

        return productOptional.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product replaceProduct(Long productId, Product request) {
        return null;
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductBasedOnUser(Long productId, Long userId) {
        Optional<Product> productOptional = productRepo.findProductById(productId);
        UserDto userDto = restTemplate.getForEntity("http://userauthservice/api/v1/auth/users/{userId}",UserDto.class, userId).getBody();
        System.out.println(userDto.getEmail());

        if(userDto != null) return productOptional.get();
        return null;
    }
}
