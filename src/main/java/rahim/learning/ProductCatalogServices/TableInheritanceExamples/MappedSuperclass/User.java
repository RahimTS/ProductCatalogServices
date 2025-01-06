package rahim.learning.ProductCatalogServices.TableInheritanceExamples.MappedSuperclass;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
    @Id
    UUID id;
    String email;
}
