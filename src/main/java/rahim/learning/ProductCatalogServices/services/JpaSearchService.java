package rahim.learning.ProductCatalogServices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import rahim.learning.ProductCatalogServices.dtos.SortParamDto;
import rahim.learning.ProductCatalogServices.dtos.SortType;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.repos.ProductRepo;

import java.util.List;

@Service
public class JpaSearchService implements ISearchService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Page<Product> search(String searchQuery, int pageNo, int pageSize, List<SortParamDto> sortParamDtoList) {

        if(searchQuery == null || searchQuery.isEmpty()) {
            return productRepo.findProductByName(searchQuery, PageRequest.of(pageNo, pageSize));
        }

        Sort sort;
        if(sortParamDtoList.get(0).getSortType().equals(SortType.ASC)) {
            sort = Sort.by(sortParamDtoList.get(0).getSortCriteria());
        } else {
            sort = Sort.by(sortParamDtoList.get(0).getSortCriteria()).descending();
        }

        for (int i = 0; i < sortParamDtoList.size(); i++) {
            if (sortParamDtoList.get(i).getSortType().equals(SortType.ASC)) {
                sort = Sort.by(sortParamDtoList.get(i).getSortCriteria()).ascending();
            } else {
                sort = Sort.by(sortParamDtoList.get(i).getSortCriteria()).descending();
            }
        }

        return productRepo.findProductByName(searchQuery, PageRequest.of(pageNo, pageSize, sort));
    }
}
