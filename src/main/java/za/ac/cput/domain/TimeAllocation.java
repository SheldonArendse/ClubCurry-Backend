package za.ac.cput.domain;

import jakarta.persistence.*;

import za.ac.cput.domain.Order;

import java.util.Date;
import java.util.Objects;

@Entity
public class TimeAllocation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String timerId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "chef_id")
    private Chef preparedBy;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order order;
    private Date datePrepared;

    protected TimeAllocation() {}

    public TimeAllocation(Builder builder) {
        this.timerId = builder.timerId;
        this.datePrepared = builder.datePrepared;
        this.preparedBy = builder.preparedBy;
        this.order = builder.order;
    }

    public String getTimerId() {
        return timerId;
    }

    public Date getDatePrepared() {
        return datePrepared;
    }

    public Chef getPreparedBy() {
        return preparedBy;
    }

    public Order getOrder() {
        return order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeAllocation that)) return false;
        return Objects.equals(getTimerId(), that.getTimerId()) && Objects.equals(getPreparedBy(), that.getPreparedBy()) && Objects.equals(getOrder(), that.getOrder()) && Objects.equals(getDatePrepared(), that.getDatePrepared());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimerId(), getPreparedBy(), getOrder(), getDatePrepared());
    }

    @Override
    public String toString() {
        return "Time Allocation" + "\n-----------------\n" +
                "Timer ID = " + timerId + "\n" +
                "Date Prepared = " + datePrepared + "\n" +
                "Prepared By = Chef " + preparedBy + "\n" +
                "Order = " + order + "\n";
    }

    public static class Builder {
        @Id
        private String timerId;
        private Date datePrepared;
        @ManyToOne
        private Chef preparedBy;
        private Order order;

        public Builder setTimerId(String timerId) {
            this.timerId = timerId;
            return this;
        }

        public Builder setDatePrepared(Date datePrepared) {
            this.datePrepared = datePrepared;
            return this;
        }

        public Builder setPreparedBy(Chef preparedBy) {
            this.preparedBy = preparedBy;
            return this;
        }

        public Builder setOrder(Order order) {
            this.order = order;
            return this;
        }

        public Builder copy(TimeAllocation obj) {
            this.timerId = obj.timerId;
            this.datePrepared = obj.datePrepared;
            this.preparedBy = obj.preparedBy;
            this.order = obj.order;
            return this;
        }

        public TimeAllocation build() {
            return new TimeAllocation(this);
        }
    }
}
