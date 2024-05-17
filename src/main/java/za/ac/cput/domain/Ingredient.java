package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String code;
    private String name;
    private int stock;

    protected Ingredient(){}

    private Ingredient(Builder obj) {
        this.code = obj.code;
        this.name = obj.name;
        this.stock =obj.stock;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return stock == that.stock && Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, stock);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }

    public static class Builder{
        private String code;
        private String name;
        private int stock;

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStock(int stock) {
            this.stock = stock;
            return this;
        }

        public Builder copy(Ingredient obj){
            this.code = obj.code;
            this.name = obj.name;
            this.stock =obj.stock;
            return this;
        }

        public Ingredient build(){
            return new Ingredient(this);
        }
    }
}
