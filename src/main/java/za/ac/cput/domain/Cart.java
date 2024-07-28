package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "customer_email")
    private Customer customer;

    @OneToMany
    private List<CartMenuItems> items;

    protected Cart(){}

    public Cart(Builder obj) {
        this.id = obj.id;
        this.customer = obj.customer;
        this.items = obj.items;
    }

    public long getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<CartMenuItems> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return id == cart.id && Objects.equals(customer, cart.customer) && Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer, items);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", customer=" + customer +
                ", items=" + items +
                '}';
    }

    public static class Builder{
        private long id;
        private Customer customer;
        private List<CartMenuItems> items;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setCustomer(Customer customer) {
            this.customer = customer;
            return this;
        }

        public Builder setItems(List<CartMenuItems> items) {
            this.items = items;
            return this;
        }

        public Builder copy(Cart obj){
            this.id = obj.id;
            this.customer = obj.customer;
            this.items = obj.items;
            return this;
        }

        public Cart build(){
            return new Cart(this);
        }
    }
}
