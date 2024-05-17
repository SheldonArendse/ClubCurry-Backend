package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Chef {
    @Id
    private String chefId;
    private int expertLevel;

    protected Chef() {}

    public Chef(Builder builder) {
        this.chefId = builder.chefId;
        this.expertLevel = builder.expertLevel;
    }

    public String getChefId() {
        return chefId;
    }

    public int getExpertLevel() {
        return expertLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Chef chef)) return false;
        return getExpertLevel() == chef.getExpertLevel() && Objects.equals(getChefId(), chef.getChefId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChefId(), getExpertLevel());
    }

    @Override
    public String toString() {
        return "Chef" + "\n-----------------\n" +
                "Chef ID = " + chefId + "\n" +
                "Expert Level = " + expertLevel + "\n";
    }

    public static class Builder {
        @Id
        private String chefId;
        private int expertLevel;

        public Builder setChefId(String chefId) {
            this.chefId = chefId;
            return this;
        }

        public Builder setExpertLevel(int expertLevel) {
            this.expertLevel = expertLevel;
            return this;
        }

        public Builder copy(Chef obj) {
            this.chefId = obj.chefId;
            this.expertLevel = obj.expertLevel;
            return this;
        }

        public Chef build() {
            return new Chef(this);
        }
    }
}
