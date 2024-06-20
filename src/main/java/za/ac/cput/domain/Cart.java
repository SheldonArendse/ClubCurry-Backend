package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "customer_email")
    private Customer customer;

    @OneToMany
    private List<MenuItem> items;
}
