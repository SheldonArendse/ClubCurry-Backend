package za.ac.cput.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private boolean delivered;

    private Date completed;

    @ManyToOne
    private Driver driver;

    @OneToOne(cascade = CascadeType.ALL)
    private Orders order;

}
