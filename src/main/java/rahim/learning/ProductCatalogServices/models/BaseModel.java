package rahim.learning.ProductCatalogServices.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@Setter
@Getter
@MappedSuperclass
public abstract class BaseModel {
    @Id
    private Long id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private State state;
}
