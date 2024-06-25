package za.ac.cput.domain;

import jakarta.persistence.Entity;
import za.ac.cput.domain.enums.ExpertLevel;

import java.util.Objects;

@Entity
public class Chef extends Employee{
    private ExpertLevel expertLevel;

    protected Chef(){}

    public Chef(Builder obj){
        this.expertLevel = obj.expertLevel;
    }

    public ExpertLevel getExpertLevel() {
        return expertLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chef chef = (Chef) o;
        return expertLevel == chef.expertLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expertLevel);
    }

    @Override
    public String toString() {
        return "Chef{" +
                "expertLevel=" + expertLevel +
                '}';
    }

    public static class Builder {
        private ExpertLevel expertLevel;

        public Builder setExpertLevel(ExpertLevel expertLevel) {
            this.expertLevel = expertLevel;
            return this;
        }

        public Builder copy(Chef obj){
            this.expertLevel = obj.expertLevel;
            return this;
        }

        public Chef build(){
            return new Chef(this);
        }
    }
}
