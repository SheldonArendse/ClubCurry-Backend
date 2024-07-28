package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

@Entity
public class CartMenuItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private MenuItem menuItem;

    private int quantity;

    private String note;

    private SpiceLevel spiceLevel;
}
