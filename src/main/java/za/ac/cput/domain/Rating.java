package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Orders order;

    private RatingStars foodQuality;

    private RatingStars DeliveryQuality;
}
