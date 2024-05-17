package za.ac.cput.domain;

import jakarta.persistence.*;

import za.ac.cput.domain.Driver;

import java.sql.Time;
import java.util.Objects;

@Entity
public class Delivery {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String deliveryId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="timer_id")
    private TimeAllocation deliveryTime;
    private Boolean status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="driver_id")
    private Driver driverId;
    private Time deliveredAt;
    private String deliveryNote;

    protected Delivery() {}

    public Delivery(Builder builder) {
        this.deliveryId = builder.deliveryId;
        this.deliveryTime = builder.deliveryTime;
        this.status = builder.status;
        this.driverId = builder.driverId;
        this.deliveredAt = builder.deliveredAt;
        this.deliveryNote = builder.deliveryNote;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public TimeAllocation getDeliveryTime() {
        return deliveryTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public Time getDeliveredAt() {
        return deliveredAt;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Delivery delivery)) return false;
        return Objects.equals(getDeliveryId(), delivery.getDeliveryId()) && Objects.equals(getDeliveryTime(), delivery.getDeliveryTime()) && Objects.equals(getStatus(), delivery.getStatus()) && Objects.equals(getDriverId(), delivery.getDriverId()) && Objects.equals(getDeliveredAt(), delivery.getDeliveredAt()) && Objects.equals(getDeliveryNote(), delivery.getDeliveryNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDeliveryId(), getDeliveryTime(), getStatus(), getDriverId(), getDeliveredAt(), getDeliveryNote());
    }

    @Override
    public String toString() {
        return "Delivery" + "\n-----------------\n" +
                "Delivery ID = " + deliveryId + "\n" +
                "Delivery Time = " + deliveryTime + "\n" +
                "Status = " + status + "\n" +
                "Driver ID = " + driverId + "\n" +
                "Delivered at = " + deliveredAt +
                "Delivery Note = " + deliveryNote;
    }

    public static class Builder {
        @Id
        private String deliveryId;
        @OneToOne
        private TimeAllocation deliveryTime;
        private Boolean status;
        @OneToOne
        private Driver driverId;
        private Time deliveredAt;
        private String deliveryNote;

        public Builder setDeliveryId(String deliveryId) {
            this.deliveryId = deliveryId;
            return this;
        }

        public Builder setDeliveryTime(TimeAllocation deliveryTime) {
            this.deliveryTime = deliveryTime;
            return this;
        }

        public Builder setStatus(Boolean status) {
            this.status = status;
            return this;
        }

        public Builder setDriverId(Driver driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setDeliveredAt(Time deliveredAt) {
            this.deliveredAt = deliveredAt;
            return this;
        }

        public Builder setDeliveryNote(String deliveryNote) {
            this.deliveryNote = deliveryNote;
            return this;
        }

        public Builder copy(Delivery obj) {
            this.deliveryId = obj.deliveryId;
            this.deliveryTime = obj.deliveryTime;
            this.status = obj.status;
            this.driverId = obj.driverId;
            this.deliveredAt = obj.deliveredAt;
            this.deliveryNote = obj.deliveryNote;
            return this;
        }

        public Delivery build() {
            return new Delivery(this);
        }
    }
}
