package rahim.learning.ProductCatalogServices.TableInheritanceExamples.SingleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_mentor")
@DiscriminatorValue(value = "20")
public class Mentor extends User {
    Double ratings;
}
