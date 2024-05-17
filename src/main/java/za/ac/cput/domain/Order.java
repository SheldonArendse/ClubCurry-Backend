package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Order {
    @Id
    private String orderId;
    private LocalTime Ordered;
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;
    private Date dateOrdered;
    private boolean Completed;

    protected Order() {

    }

    public Order(Builder builder) {
        this.orderId = builder.orderId;
        Ordered = builder.Ordered;
        this.cart = builder.cart;
        this.dateOrdered = builder.dateOrdered;
        this.Completed = builder.Completed;
    }

    public String getOrderId() {
        return orderId;
    }

    public LocalTime getOrdered() {
        return Ordered;
    }

    public Cart getCart() {
        return cart;
    }

    public Date getDateOrdered() {
        return dateOrdered;
    }

    public boolean isCompleted() {
        return Completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Completed == order.Completed && Objects.equals(orderId, order.orderId) && Objects.equals(Ordered, order.Ordered) && Objects.equals(cart, order.cart) && Objects.equals(dateOrdered, order.dateOrdered);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, Ordered, cart, dateOrdered, Completed);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", Ordered=" + Ordered +
                ", cart=" + cart +
                ", dateOrdered=" + dateOrdered +
                ", Completed=" + Completed +
                '}';
    }

    public static class Builder{
        private String orderId;
        private LocalTime Ordered;
        private Cart cart;
        private Date dateOrdered;
        private boolean Completed;

        public Builder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public Builder setOrdered(LocalTime ordered) {
            Ordered = ordered;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setDateOrdered(Date dateOrdered) {
            this.dateOrdered = dateOrdered;
            return this;
        }

        public Builder setCompleted(boolean completed) {
            Completed = completed;
            return this;
        }
        public Builder copy(Order order){
            this.orderId = order.orderId;
            this.Ordered = order.Ordered;
            this.cart = order.cart;
            this.dateOrdered = order.dateOrdered;
            this.Completed = order.Completed;
            return this;
        }
        public Order build(){
            return new Order(this);
        }

    }
}
