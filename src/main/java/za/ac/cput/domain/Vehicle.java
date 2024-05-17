package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity

public class Vehicle {
    @Id
    String registrationNumber;
    String model;
    String color;
    String make;

    public Vehicle() {

    }
    public Vehicle(Builder builder) {
        this.registrationNumber = builder.registrationNumber;
        this.model = builder.model;
        this.color = builder.color;
        this.make = builder.make;
    }

    public String getRegistration() {
        return registrationNumber
                ;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public String getMake() {
        return make;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber) && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color) && Objects.equals(make, vehicle.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber, model, color, make);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "registration='" + registrationNumber + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                '}';
    }

    public static class Builder{
        String registrationNumber;
        String model;
        String color;
        String make;

        public Builder setRegistration(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder setModel(String model) {
            this.model = model;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setMake(String make) {
            this.make = make;
            return this;
        }

        public Builder copy(Vehicle obj){
            this.registrationNumber = obj.registrationNumber;
            this.model = obj.model;
            this.color = obj.color;
            this.make = obj.make;
            return this;
        }

        Vehicle build(){
            return new Vehicle(this);
        }
    }
}