package rahim.learning.ProductCatalogServices.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rahim.learning.ProductCatalogServices.dtos.SearchRequestDto;
import rahim.learning.ProductCatalogServices.models.Product;
import rahim.learning.ProductCatalogServices.services.ISearchService;

@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private ISearchService searchService;

    @PostMapping
    public Page<Product> searchProducts(@RequestBody SearchRequestDto searchRequestDto) {
        return searchService.search(searchRequestDto.getSearchQuery(),
                searchRequestDto.getPageNumber(), searchRequestDto.getPageSize(),
                searchRequestDto.getSortParam());
    }
}
