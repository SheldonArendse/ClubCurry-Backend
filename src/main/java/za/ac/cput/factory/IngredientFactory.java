package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.utils.Validation;

public class IngredientFactory {

    public static Ingredient buildIngredient(String name, int stock){
        if(Validation.isValidString(name) && stock>=0){
            return new Ingredient.Builder().setName(name).setStock(stock).build();
        }
        return null;
    }

    public static Ingredient buildIngredient(long id, String name, int stock){
        if(Validation.isValidString(name) && stock>=0){
            return new Ingredient.Builder().setName(name).setStock(stock).setId(id).build();
        }
        return null;
    }

}
