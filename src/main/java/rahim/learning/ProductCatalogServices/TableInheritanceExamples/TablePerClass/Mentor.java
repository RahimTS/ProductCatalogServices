package rahim.learning.ProductCatalogServices.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
public class Mentor extends User {
    Double ratings;
}
