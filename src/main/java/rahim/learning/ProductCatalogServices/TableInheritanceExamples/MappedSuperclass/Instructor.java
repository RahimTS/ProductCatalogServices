package rahim.learning.ProductCatalogServices.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_instructor")
public class Instructor extends User {
    String company;     
}
