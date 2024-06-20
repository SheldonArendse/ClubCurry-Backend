package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class StockOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<Ingredient> ingredients;

    private int units;

    private double total;

    private boolean fulfilled;

    @ManyToOne
    private Supplier supplier;


}
