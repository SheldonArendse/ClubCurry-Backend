package za.ac.cput.domain;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Special {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date expires;

    private double price;

    @OneToOne
    private MenuItem item;
}
