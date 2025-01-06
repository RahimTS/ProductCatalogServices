package rahim.learning.ProductCatalogServices.TableInheritanceExamples.TablePerClass;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "tpc_user")
public class User {
    @Id
    UUID id;
    String email;
}
