package za.ac.cput.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.UniqueConstraint;

@MappedSuperclass
public class Employee {
    @Id
    private String id;

    private String name, surname, username, password;
}
