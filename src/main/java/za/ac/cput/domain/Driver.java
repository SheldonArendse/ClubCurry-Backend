package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Driver extends Employee{

    private double petrolAllowance;

    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle registration;

    protected Driver(){}

    public Driver(Builder obj){
        this.petrolAllowance = obj.petrolAllowance;
        this.registration = obj.registration;
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
        this.password = obj.password;
        this.username = obj.username;
    }

    public double getPetrolAllowance() {
        return petrolAllowance;
    }

    public Vehicle getRegistration() {
        return registration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return Double.compare(petrolAllowance, driver.petrolAllowance) == 0 && Objects.equals(registration, driver.registration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petrolAllowance, registration);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "petrolAllowance=" + petrolAllowance +
                ", registration=" + registration +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private double petrolAllowance;

        @OneToOne(cascade = CascadeType.ALL)
        private Vehicle registration;

        protected String id;

        protected String name, surname, username, password;
}
