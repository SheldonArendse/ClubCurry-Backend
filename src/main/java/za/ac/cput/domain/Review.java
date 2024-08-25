package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

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

    protected Review(){}

    public Review(Builder obj) {
        this.id = obj.id;
        this.rating = obj.rating;
        this.customer = obj.customer;
        this.note = obj.note;
    }

    public long getId() {
        return id;
    }

    public Rating getRating() {
        return rating;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getNote() {
        return note;
    }

}
