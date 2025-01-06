package rahim.learning.ProductCatalogServices.TableInheritanceExamples.MappedSuperclass;

import jakarta.persistence.Entity;

@Entity(name = "msc_ta")
public class Ta extends User {
    int helpRequest;

}
