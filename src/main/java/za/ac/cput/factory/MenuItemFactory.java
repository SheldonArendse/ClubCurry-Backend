package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.utils.Validation;

import java.util.List;

public class MenuItemFactory {

    public static MenuItem buildMenuItem(String name, double price, Menu menu, List<Ingredient> ingredients){
        if(Validation.isValidString(name) && price >0 && menu !=null && !ingredients.isEmpty()){
            return new MenuItem.Builder()
                    .setName(name)
                    .setPrice(price)
                    .setMenuId(menu)
                    .setIngredients(ingredients).build();
        }
        return null;
    }

    public static MenuItem buildMenuItem(Long id, String name, double price, Menu menu, List<Ingredient> ingredients){
        if(Validation.isValidString(name) && price >0 && menu !=null && !ingredients.isEmpty()){
            return new MenuItem.Builder()
                    .setId(id)
                    .setName(name)
                    .setPrice(price)
                    .setMenuId(menu)
                    .setIngredients(ingredients).build();
        }
        return null;
    }
}
