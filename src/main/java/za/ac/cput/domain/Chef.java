package za.ac.cput.domain;

import jakarta.persistence.Entity;
import za.ac.cput.domain.enums.ExpertLevel;

import java.util.Objects;

@Entity
public class Chef extends Employee{
    private ExpertLevel expertLevel;

    protected Chef(){}

    public Chef(Builder obj){
        this.id = obj.id;
        this.name = obj.name;
        this.surname = obj.surname;
        this.password = obj.password;
        this.username = obj.username;
        this.expertLevel = obj.expertLevel;
    }

    public ExpertLevel getExpertLevel() {
        return expertLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chef chef = (Chef) o;
        return expertLevel == chef.expertLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expertLevel);
    }

    @Override
    public String toString() {
        return "Chef{" +
                "expertLevel=" + expertLevel +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class Builder{
        private String id;

        private String name, surname, username, password;

        private ExpertLevel expertLevel;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setExpertLevel(ExpertLevel expertLevel) {
            this.expertLevel = expertLevel;
            return this;
        }

        public Builder copy(Chef obj){
            this.id = obj.id;
            this.name = obj.name;
            this.surname = obj.surname;
            this.password = obj.password;
            this.username = obj.username;
            this.expertLevel = obj.expertLevel;
            return this;
        }

        public Chef build(){
            return new Chef(this);
        }
    }
}
