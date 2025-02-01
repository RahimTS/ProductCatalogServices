package rahim.learning.ProductCatalogServices.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
    private String name;
    private String description;
    private String imageUrl;
    private Double price;
    @JsonManagedReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private Boolean isPrime;
}
