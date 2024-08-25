package za.ac.cput.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import za.ac.cput.domain.embedded.Suburb;

import java.util.Objects;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String streetName, streetNo;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="suburbName", column = @Column(name = "suburb_name")),
            @AttributeOverride(name="postalCode", column = @Column(name = "suburb_postal_code"))
    })
    private Suburb suburb;

    @JsonBackReference
    @ManyToOne
    private Customer customerId;

    protected Address(){};

    public Address(Builder obj) {
        this.id = obj.id;
        this.streetName = obj.streetName;
        this.streetNo = obj.streetNo;
        this.suburb = obj.suburb;
        this.customerId = obj.customerId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public long getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public Suburb getSuburb() {
        return suburb;
    }


}
