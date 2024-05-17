package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity

public class Driver extends Employee{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String driverId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="registrationNumber")
    Vehicle registrationNumber;

    public Driver() {

    }

    public Driver(Builder builder) {
        this.driverId = builder.driverId;
        this.registrationNumber = builder.registrationNumber;
    }


    public String getDriverId() {
        return driverId;
    }

    public Vehicle getRegistration() {
        return registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(driverId, driver.driverId) && Objects.equals(registrationNumber, driver.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driverId, registrationNumber);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId='" + driverId + '\'' +
                ", registration=" + registrationNumber +
                '}';
    }

    public static class Builder{
        String driverId;
        Vehicle registrationNumber;

        public Builder setDriverId(String driverId) {
            this.driverId = driverId;
            return this;
        }

        public Builder setRegistration(Vehicle registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder copy(Driver obj){
            this.driverId = obj.driverId;
            this.registrationNumber = obj.registrationNumber;
            return this;

        }
        Driver build(){
            return new Driver(this);
        }
    }
}
