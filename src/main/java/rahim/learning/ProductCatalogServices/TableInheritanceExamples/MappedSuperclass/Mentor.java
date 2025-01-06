package rahim.learning.ProductCatalogServices.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_mentor")
public class Mentor extends User {
    Double ratings;
}
