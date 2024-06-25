package za.ac.cput.domain;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;

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

    protected Delivery(){}

    public Delivery(Builder obj) {
        this.id = obj.id;
        this.delivered = obj.delivered;
        this.completed = obj.completed;
        this.driver = obj.driver;
        this.order = obj.order;
    }

    public long getId() {
        return id;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public Date getCompleted() {
        return completed;
    }

    public Driver getDriver() {
        return driver;
    }

    public Orders getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id && delivered == delivery.delivered && Objects.equals(completed, delivery.completed) && Objects.equals(driver, delivery.driver) && Objects.equals(order, delivery.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, delivered, completed, driver, order);
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", delivered=" + delivered +
                ", completed=" + completed +
                ", driver=" + driver +
                ", order=" + order +
                '}';
    }

    public static class Builder{
        private long id;

        private boolean delivered;

        private Date completed;

        private Driver driver;

        private Orders order;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setDelivered(boolean delivered) {
            this.delivered = delivered;
            return this;
        }

        public Builder setCompleted(Date completed) {
            this.completed = completed;
            return this;
        }

        public Builder setDriver(Driver driver) {
            this.driver = driver;
            return this;
        }

        public Builder setOrder(Orders order) {
            this.order = order;
            return this;
        }

        public Builder copy(Delivery obj){
            this.id = obj.id;
            this.delivered = obj.delivered;
            this.completed = obj.completed;
            this.driver = obj.driver;
            this.order = obj.order;
            return this;
        }

        public Delivery build(){
            return new Delivery(this);
        }
    }
}
