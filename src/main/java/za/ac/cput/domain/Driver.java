package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Driver extends Employee{
    private double petrolAllowance;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle registration;
}
