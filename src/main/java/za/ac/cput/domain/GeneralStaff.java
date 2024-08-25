package za.ac.cput.domain;

import jakarta.persistence.Entity;
import za.ac.cput.domain.enums.ExpertLevel;

import java.util.Objects;

@Entity
public class GeneralStaff extends Employee{

    protected GeneralStaff(){}

    public GeneralStaff(Builder obj){
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
        this.password = obj.password;
        this.username = obj.username;
    }

    @Override
    public String toString() {
        return "GeneralStaff{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
