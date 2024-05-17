package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String menuId;
    private String menuName;
    private String SpiceLevel;

    protected Menu(){}

    private Menu(Builder obj){
        this.menuId = obj.menuId;
        this.menuName = obj.menuName;
        this.SpiceLevel = obj.SpiceLevel;
    }

    public String getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public String getSpiceLevel() {
        return SpiceLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(menuId, menu.menuId) && Objects.equals(menuName, menu.menuName) && Objects.equals(SpiceLevel, menu.SpiceLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuName, SpiceLevel);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId='" + menuId + '\'' +
                ", menuName='" + menuName + '\'' +
                ", SpiceLevel='" + SpiceLevel + '\'' +
                '}';
    }

    public static class Builder{
        private String menuId;
        private String menuName;
        private String SpiceLevel;

        public Builder setMenuId(String menuId) {
            this.menuId = menuId;
            return this;
        }

        public Builder setMenuName(String menuName) {
            this.menuName = menuName;
            return this;
        }

        public Builder setSpiceLevel(String spiceLevel) {
            SpiceLevel = spiceLevel;
            return this;
        }

        public Builder copy(Menu obj){
            this.menuId = obj.menuId;
            this.menuName = obj.menuName;
            this.SpiceLevel = obj.SpiceLevel;
            return this;
        }

        public Menu build(){
            return new Menu(this);
        }
    }
}
