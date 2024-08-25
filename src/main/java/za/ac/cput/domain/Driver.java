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
}
