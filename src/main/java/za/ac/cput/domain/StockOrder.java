package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class StockOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany
    private List<Ingredient> ingredients;

    private int units;

    private double total;

    private boolean fulfilled;

    @ManyToOne
    private Supplier supplier;

    protected StockOrder(){}

    public StockOrder(Builder obj) {
        this.id = obj.id;
        this.ingredients = obj.ingredients;
        this.units = obj.units;
        this.total = obj.total;
        this.fulfilled = obj.fulfilled;
        this.supplier = obj.supplier;
    }

    public long getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public int getUnits() {
        return units;
    }

    public double getTotal() {
        return total;
    }

    public boolean isFulfilled() {
        return fulfilled;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockOrder that = (StockOrder) o;
        return id == that.id && units == that.units && Double.compare(total, that.total) == 0 && fulfilled == that.fulfilled && Objects.equals(ingredients, that.ingredients) && Objects.equals(supplier, that.supplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ingredients, units, total, fulfilled, supplier);
    }

    @Override
    public String toString() {
        return "StockOrder{" +
                "id=" + id +
                ", ingredients=" + ingredients +
                ", units=" + units +
                ", total=" + total +
                ", fulfilled=" + fulfilled +
                ", supplier=" + supplier +
                '}';
    }

    public static class Builder{
        private long id;

        private List<Ingredient> ingredients;

        private int units;

        private double total;

        private boolean fulfilled;

        private Supplier supplier;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder setUnits(int units) {
            this.units = units;
            return this;
        }

        public Builder setTotal(double total) {
            this.total = total;
            return this;
        }

        public Builder setFulfilled(boolean fulfilled) {
            this.fulfilled = fulfilled;
            return this;
        }

        public Builder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder copy(StockOrder obj){
            this.id = obj.id;
            this.ingredients = obj.ingredients;
            this.units = obj.units;
            this.total = obj.total;
            this.fulfilled = obj.fulfilled;
            this.supplier = obj.supplier;
            return this;
        }

        public StockOrder build(){
            return new StockOrder(this);
        }
    }
}
