package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.CollectionType;
import za.ac.cput.domain.enums.PaymentMethod;

import java.sql.Date;
import java.util.Objects;

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
    private GeneralStaff preparedBy;

    protected Orders(){}

    public Orders(Builder obj) {
        this.id = obj.id;
        this.ordered = obj.ordered;
        this.cart = obj.cart;
        this.total = obj.total;
        this.orderWanted = obj.orderWanted;
        this.isComplete = obj.isComplete;
        this.paymentMethod = obj.paymentMethod;
        this.collectionType = obj.collectionType;
        this.preparedBy = obj.preparedBy;
    }

    public long getId() {
        return id;
    }

    public Date getOrdered() {
        return ordered;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotal() {
        return total;
    }

    public Date getOrderWanted() {
        return orderWanted;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public CollectionType getCollectionType() {
        return collectionType;
    }

    public GeneralStaff getPreparedBy() {
        return preparedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Double.compare(total, orders.total) == 0 && isComplete == orders.isComplete && Objects.equals(ordered, orders.ordered) && Objects.equals(cart, orders.cart) && Objects.equals(orderWanted, orders.orderWanted) && paymentMethod == orders.paymentMethod && collectionType == orders.collectionType && Objects.equals(preparedBy, orders.preparedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ordered, cart, total, orderWanted, isComplete, paymentMethod, collectionType, preparedBy);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", ordered=" + ordered +
                ", cart=" + cart +
                ", total=" + total +
                ", orderWanted=" + orderWanted +
                ", isComplete=" + isComplete +
                ", paymentMethod=" + paymentMethod +
                ", collectionType=" + collectionType +
                ", preparedBy=" + preparedBy +
                '}';
    }

    public static class Builder{
        private long id;

        private Date ordered;

        private Cart cart;

        private double total;

        private Date orderWanted;

        private boolean isComplete;

        private PaymentMethod paymentMethod;

        private CollectionType collectionType;

        private GeneralStaff preparedBy;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setOrdered(Date ordered) {
            this.ordered = ordered;
            return this;
        }

        public Builder setCart(Cart cart) {
            this.cart = cart;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder setOrderWanted(Date orderWanted) {
            this.orderWanted = orderWanted;
            return this;
        }

        public Builder setComplete(boolean complete) {
            isComplete = complete;
            return this;
        }

        public Builder setPaymentMethod(PaymentMethod paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder setCollectionType(CollectionType collectionType) {
            this.collectionType = collectionType;
            return this;
        }

        public Builder setPreparedBy(GeneralStaff preparedBy) {
            this.preparedBy = preparedBy;
            return this;
        }

        public Builder copy(Orders obj){
            this.id = obj.id;
            this.ordered = obj.ordered;
            this.cart = obj.cart;
            this.total = obj.total;
            this.orderWanted = obj.orderWanted;
            this.isComplete = obj.isComplete;
            this.paymentMethod = obj.paymentMethod;
            this.collectionType = obj.collectionType;
            this.preparedBy = obj.preparedBy;
            return this;
        }

        public Orders build(){
            return new Orders(this);
        }
    }
}
