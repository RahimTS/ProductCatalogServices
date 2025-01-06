package rahim.learning.ProductCatalogServices.TableInheritanceExamples.JoinedClass;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "jc_user")
public class User {
    @Id
    UUID id;
    String email;
}
