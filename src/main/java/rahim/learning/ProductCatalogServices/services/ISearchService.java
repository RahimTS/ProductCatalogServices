package rahim.learning.ProductCatalogServices.services;

import org.springframework.data.domain.Page;
import rahim.learning.ProductCatalogServices.dtos.SortParamDto;
import rahim.learning.ProductCatalogServices.models.Product;

import java.util.List;

public interface ISearchService {
    Page<Product> search(String searchQuery, int pageNo, int pageSize, List<SortParamDto> sortParamDtoList);
}
