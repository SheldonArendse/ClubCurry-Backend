package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.RatingStars;

import java.util.Objects;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Orders order;

    private RatingStars foodQuality;

    private RatingStars deliveryQuality;

    protected Rating(){}

    public Rating(Builder obj) {
        this.id = obj.id;
        this.order = obj.order;
        this.foodQuality = obj.foodQuality;
        this.deliveryQuality = obj.deliveryQuality;
    }

    public long getId() {
        return id;
    }

    public Orders getOrder() {
        return order;
    }

    public RatingStars getFoodQuality() {
        return foodQuality;
    }

    public RatingStars getDeliveryQuality() {
        return deliveryQuality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id == rating.id && Objects.equals(order, rating.order) && foodQuality == rating.foodQuality && deliveryQuality == rating.deliveryQuality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, order, foodQuality, deliveryQuality);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", order=" + order +
                ", foodQuality=" + foodQuality +
                ", deliveryQuality=" + deliveryQuality +
                '}';
    }

    public static class Builder{
        private long id;

        private Orders order;

        private RatingStars foodQuality;

        private RatingStars deliveryQuality;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setOrder(Orders order) {
            this.order = order;
            return this;
        }

        public Builder setFoodQuality(RatingStars foodQuality) {
            this.foodQuality = foodQuality;
            return this;
        }

        public Builder setDeliveryQuality(RatingStars deliveryQuality) {
            deliveryQuality = deliveryQuality;
            return this;
        }

        public Builder copy(Rating obj){
            this.id = obj.id;
            this.order = obj.order;
            this.foodQuality = obj.foodQuality;
            this.deliveryQuality = obj.deliveryQuality;
            return this;
        }

        public Rating build(){
            return new Rating(this);
        }
    }
}
