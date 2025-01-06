package rahim.learning.ProductCatalogServices.TableInheritanceExamples.SingleTable;

import java.util.UUID;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@Entity(name = "st_user")
public class User {
    @Id
    UUID id;
    String email;
}
