package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

import java.util.Objects;

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

    public CartMenuItems(Builder obj) {
        this.id = obj.id;
        this.menuItem = obj.menuItem;
        this.quantity = obj.quantity;
        this.note = obj.note;
        this.spiceLevel = obj.spiceLevel;
    }

    protected CartMenuItems() {
    }

    public Long getId() {
        return id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getNote() {
        return note;
    }

    public SpiceLevel getSpiceLevel() {
        return spiceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartMenuItems that = (CartMenuItems) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(menuItem, that.menuItem) && Objects.equals(note, that.note) && spiceLevel == that.spiceLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuItem, quantity, note, spiceLevel);
    }

    @Override
    public String toString() {
        return "CartMenuItems{" +
                "id=" + id +
                ", menuItem=" + menuItem +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", spiceLevel=" + spiceLevel +
                '}';
    }

    
}
