package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.utils.Validation;
public class IngredientFactory {

    public static Ingredient buildIngredient(String name){
        if(Validation.isValidString(name)){
            return new Ingredient.Builder().setName(name).build();
        }
        return null;
    }
}
