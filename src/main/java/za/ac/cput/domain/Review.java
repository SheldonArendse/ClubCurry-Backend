package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;

    private String note;
}
