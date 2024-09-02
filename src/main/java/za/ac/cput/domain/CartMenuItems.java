package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.SpiceLevel;

import java.util.Objects;

/**
 * Represents an item in the cart that corresponds to a menu item.
 * It includes details such as the quantity, note, and spice level of the item.
 */
@Entity
public class CartMenuItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier for the CartMenuItems

    @ManyToOne
    private MenuItem menuItem; // MenuItem associated with this CartMenuItems

    private int quantity; // Quantity of the MenuItem in the cart

    private String note; // Note related to the MenuItem in the cart

    private SpiceLevel spiceLevel; // Spice level preference for the MenuItem

    // Constructor using Builder pattern to initialize a CartMenuItems instance
    public CartMenuItems(Builder obj) {
        this.id = obj.id;
        this.menuItem = obj.menuItem;
        this.quantity = obj.quantity;
        this.note = obj.note;
        this.spiceLevel = obj.spiceLevel;
    }

    // Protected no-args constructor for JPA
    protected CartMenuItems() {}

    // Getter methods for accessing private fields
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

    // Overrides equals method to compare two CartMenuItems objects based on their fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartMenuItems that = (CartMenuItems) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(menuItem, that.menuItem) && Objects.equals(note, that.note) && spiceLevel == that.spiceLevel;
    }

    // Overrides hashCode method to generate a hash code for the CartMenuItems object
    @Override
    public int hashCode() {
        return Objects.hash(id, menuItem, quantity, note, spiceLevel);
    }

    // Overrides toString method to provide a string representation of the CartMenuItems object
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

    /**
     * Builder class for constructing a CartMenuItems object using the Builder pattern.
     */
    public static class Builder {
        private Long id;
        private MenuItem menuItem;
        private int quantity;
        private String note;
        private SpiceLevel spiceLevel;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setMenuItem(MenuItem menuItem) {
            this.menuItem = menuItem;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setNote(String note) {
            this.note = note;
            return this;
        }

        public Builder setSpiceLevel(SpiceLevel spiceLevel) {
            this.spiceLevel = spiceLevel;
            return this;
        }

        // Copies the fields from an existing CartMenuItems object to this Builder
        public Builder copy(CartMenuItems obj) {
            this.id = obj.id;
            this.menuItem = obj.menuItem;
            this.quantity = obj.quantity;
            this.note = obj.note;
            this.spiceLevel = obj.spiceLevel;
            return this;
        }

        // Builds and returns a CartMenuItems instance using the Builder pattern
        public CartMenuItems build() {
            return new CartMenuItems(this);
        }
    }
}
