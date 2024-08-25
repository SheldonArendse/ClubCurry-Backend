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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id == review.id && Objects.equals(rating, review.rating) && Objects.equals(customer, review.customer) && Objects.equals(note, review.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, customer, note);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", rating=" + rating +
                ", customer=" + customer +
                ", note='" + note + '\'' +
                '}';
    }

}
