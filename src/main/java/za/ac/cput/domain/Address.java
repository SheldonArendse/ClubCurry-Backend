package za.ac.cput.domain;

import jakarta.persistence.*;

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
}
