package rahim.learning.ProductCatalogServices.TableInheritanceExamples.TablePerClass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_ta")
public class Ta extends User {
    int helpRequest;

}
