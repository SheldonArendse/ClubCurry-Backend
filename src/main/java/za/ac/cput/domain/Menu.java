package za.ac.cput.domain;

import jakarta.persistence.*;
import za.ac.cput.domain.enums.SpiceLevel;

import java.util.Objects;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private long id;

    private String name;


    protected Menu(){}

    public Menu(Builder obj) {
        this.id = obj.id;
        this.name = obj.name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return id == menu.id && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static class Builder{
        private long id;

        private String name;

        public Builder setId(long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder copy(Menu obj){
            this.id = obj.id;
            this.name = obj.name;
            return this;
        }

        public Menu build(){
            return new Menu(this);
        }
    }
}
