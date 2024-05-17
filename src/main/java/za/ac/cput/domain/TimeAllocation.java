package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import java.util.Date;
import java.util.Objects;

@Entity
public class TimeAllocation {
    @Id
    private String timerId;
    @OneToOne
    private Chef preparedBy;
//    @OneToOne
//    private Order order;
    private Date datePrepared;

    protected TimeAllocation() {}

    public TimeAllocation(Builder builder) {
        this.timerId = builder.timerId;
        this.datePrepared = builder.datePrepared;
    }

    public String getTimerId() {
        return timerId;
    }

    public Date getDatePrepared() {
        return datePrepared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeAllocation that)) return false;
        return Objects.equals(getTimerId(), that.getTimerId()) && Objects.equals(getDatePrepared(), that.getDatePrepared());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTimerId(), getDatePrepared());
    }

    @Override
    public String toString() {
        return "Time Allocation" + "\n-----------------\n" +
                "Timer ID = " + timerId + "\n" +
                "Date Prepared = " + datePrepared + "\n";
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

        public Builder copy(TimeAllocation obj) {
            this.timerId = obj.timerId;
            this.datePrepared = obj.datePrepared;
            return this;
        }

        public TimeAllocation build() {
            return new TimeAllocation(this);
        }
    }
}
