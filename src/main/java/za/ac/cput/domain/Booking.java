package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import za.ac.cput.domain.enums.Section;
import za.ac.cput.domain.enums.Status;

import java.sql.Date;
import java.util.Objects;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    private Date time;

    private int tableNo;

    private Section sectionNo;

    private Status status;

    protected Booking() {
    }

    public Booking(Builder obj) {
        this.bookingId = obj.bookingId;
        this.time = obj.time;
        this.tableNo = obj.tableNo;
        this.sectionNo = obj.sectionNo;
        this.status = obj.status;
    }

    public long getBookingId() {
        return bookingId;
    }

    public Date getTime() {
        return time;
    }

    public int getTableNo() {
        return tableNo;
    }

    public Section getSectionNo() {
        return sectionNo;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return bookingId == booking.bookingId && tableNo == booking.tableNo && sectionNo == booking.sectionNo && Objects.equals(time, booking.time) && status == booking.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, time, tableNo, sectionNo, status);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", time=" + time +
                ", tableNo=" + tableNo +
                ", sectionNo=" + sectionNo +
                ", status=" + status +
                '}';
    }

    public static class Builder{
        private long bookingId;
        private Date time;

        private int tableNo;

        private Section sectionNo;
        private Status status;

        public Builder setBookingId(long bookingId) {
            this.bookingId = bookingId;
            return this;
        }

        public Builder setTime(Date time) {
            this.time = time;
            return this;
        }

        public Builder setTableNo(int tableNo) {
            this.tableNo = tableNo;
            return this;
        }

        public Builder setSectionNo(Section sectionNo) {
            this.sectionNo = sectionNo;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder copy(Booking obj){
            this.bookingId = obj.bookingId;
            this.time = obj.time;
            this.tableNo = obj.tableNo;
            this.sectionNo = obj.sectionNo;
            this.status = obj.status;
            return this;
        }

        public Booking build(){
            return new Booking(this);
        }
    }
}
