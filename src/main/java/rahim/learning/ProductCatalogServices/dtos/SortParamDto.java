package rahim.learning.ProductCatalogServices.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SortParamDto {
    private SortType sortType;
    private String sortCriteria;
}
