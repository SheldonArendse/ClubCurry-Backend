package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;
import za.ac.cput.utils.Validation;

import java.util.List;

public class MenuItemFactory {
    public static MenuItem buildMenuItem(Long id) {
        if (id>0) {
            return new MenuItem.Builder().setId(id)
                    .build();
        }
        return null;
    }

    public static MenuItem buildMenuItem(Long id,String description, String name, double price, Menu menu, List<Ingredient> ingredients) {
        if (id > 0 && Validation.isValidString(name) && price > 0 && menu != null) {
            return new MenuItem.Builder().setDescription(description)
                    .setId(id)
                    .setName(name)
                    .setPrice(price)
                    .setIngredients(ingredients)
                    .setMenuId(menu).build();
        }
        return null;
    }

    public static MenuItem buildMenuItem(String description, String name, double price, Menu menu) {
        if (Validation.isValidString(name) && price > 0 && menu != null && description !=null && !description.isEmpty()) {
            return new MenuItem.Builder()
                    .setName(name).setDescription(description)
                    .setPrice(price)
                    .setMenuId(menu).build();
        }
        return null;
    }
    public static MenuItem buildMenuItem(String description, String name, double price) {
        if (Validation.isValidString(name) && price > 0 && description !=null && !description.isEmpty()) {
            return new MenuItem.Builder()
                    .setName(name).setDescription(description)
                    .setPrice(price).build();
        }
        return null;
    }
    public static MenuItem buildMenuItem(Long id, String description, String name, double price, Menu menu) {
        if (Validation.isValidString(name) && price > 0 && description !=null && !description.isEmpty()) {
            return new MenuItem.Builder().setId(id).setMenuId(menu)
                    .setName(name).setDescription(description)
                    .setPrice(price).build();
        }
        return null;
    }
    public static MenuItem buildMenuItem(Long id, String name, double price, Menu menu,String description, List<Ingredient> ingredients) {
        if (id > 0 && Validation.isValidString(name) && price > 0 && menu != null&& description !=null && !description.isEmpty()) {
            return new MenuItem.Builder()
                    .setId(id).setDescription(description)
                    .setName(name)
                    .setPrice(price)
                    .setIngredients(ingredients)
                    .setMenuId(menu).build();
        }
        return null;
    }

}
