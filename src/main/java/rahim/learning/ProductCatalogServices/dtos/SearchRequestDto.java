package rahim.learning.ProductCatalogServices.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class SearchRequestDto {
    int pageSize;
    int pageNumber;
    String searchQuery;
    List<SortParamDto> sortParam = new ArrayList<>();
}
