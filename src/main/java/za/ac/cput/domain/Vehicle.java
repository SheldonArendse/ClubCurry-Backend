package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Vehicle {

    @Id
    private long id;

    private String model, color, make;
}
