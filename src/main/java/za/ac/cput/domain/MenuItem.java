package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private double price;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menuId;

    @OneToMany
    private List<Ingredient> ingredients;

    protected MenuItem(){}

    public MenuItem(Builder obj) {
        this.id = obj.id;
        this.name = obj.name;
        this.price = obj.price;
        this.menuId = obj.menuId;
        this.ingredients = obj.ingredients;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Menu getMenuId() {
        return menuId;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id && Double.compare(price, menuItem.price) == 0 && Objects.equals(name, menuItem.name) && Objects.equals(menuId, menuItem.menuId) && Objects.equals(ingredients, menuItem.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, menuId, ingredients);
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", menuId=" + menuId +
                ", ingredients=" + ingredients +
                '}';
    }

    public static class Builder{
        private long id;
        private String name;
        private double price;
        private Menu menuId;
        private List<Ingredient> ingredients;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setMenuId(Menu menuId) {
            this.menuId = menuId;
            return this;
        }

        public Builder setIngredients(List<Ingredient> ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public Builder copy(MenuItem obj){
            this.id = obj.id;
            this.name = obj.name;
            this.price = obj.price;
            this.menuId = obj.menuId;
            this.ingredients = obj.ingredients;
            return this;
        }

        public MenuItem build(){
            return new MenuItem(this);
        }
    }
}
