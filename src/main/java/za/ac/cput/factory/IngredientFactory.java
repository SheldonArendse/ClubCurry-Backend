package za.ac.cput.factory;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.util.Helper;

public class IngredientFactory {
    public static Ingredient buildIngredient(String code, String name, int stock){
        if(Helper.isNullOrEmpty(code) || Helper.isNullOrEmpty(name) || Helper.isNull(stock)){
            return null;
        }
        return new Ingredient.Builder().setCode(code).setName(name).setStock(stock).build();
    }
    public static Ingredient buildIngredient(String name, int stock){
        if(Helper.isNullOrEmpty(name) || Helper.isNull(stock)){
            return null;
        }
        return new Ingredient.Builder().setName(name).setStock(stock).build();
    }
}
