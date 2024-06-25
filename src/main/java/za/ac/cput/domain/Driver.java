package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Driver extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double petrolAllowance;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle registration;
}
