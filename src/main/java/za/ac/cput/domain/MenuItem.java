package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menuId;

    @OneToMany
    private List<Ingredient> ingredients;
}
