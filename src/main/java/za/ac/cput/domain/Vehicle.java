package za.ac.cput.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Vehicle {

    @Id
    private long id;

    private String model, color, make;

    protected Vehicle() {
    }

    public Vehicle(Builder obj) {
        this.id = obj.id;
        this.model = obj.model;
        this.color = obj.color;
        this.make = obj.make;
    }

    public long getId() {
        return id;
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
        return id == vehicle.id && Objects.equals(model, vehicle.model) && Objects.equals(color, vehicle.color) && Objects.equals(make, vehicle.make);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color, make);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}