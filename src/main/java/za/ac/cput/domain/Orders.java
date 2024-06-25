package za.ac.cput.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date ordered;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    private double total;

    private Date orderWanted;

    private boolean isComplete;

    private PaymentMethod paymentMethod;

    private CollectionType collectionType;

    @OneToOne(cascade = CascadeType.ALL)
    private Chef preparedBy;
}
