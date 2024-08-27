package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.factory.IngredientFactory;
import za.ac.cput.service.IngredientService;
import za.ac.cput.service.MenuItemService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class IngredientMenuItem {

    private IngredientService ingredientService;
    private MenuItemService menuItemService;

    @Autowired
    public IngredientMenuItem(IngredientService ingredientService, MenuItemService menuItemService) {
        this.ingredientService = ingredientService;
        this.menuItemService = menuItemService;
    }

    /* -This method validates the ingredients in a given MenuItem object to ensure that all the ingredients are valid

       -Iterates over the list of ingredients in the MenuItem.
       -For each ingredient, it checks if the ingredient exists in the system using the ingredientService.read(ingredient.getId()) method.
       -If any ingredient is not found (ingredientService.read(ingredient.getId()) returns null), it adds that ingredient to the invalidIngredients list.
       -If the invalidIngredients list is empty (meaning all ingredients are valid), it saves the MenuItem using menuItemService.save(obj) and returns the saved MenuItem.
       -If there are invalid ingredients, it returns null.
     */
    public MenuItem validIngredients(MenuItem obj){
        List<Ingredient> invalidIngredients = new ArrayList<>();
        for(Ingredient ingredient : obj.getIngredients()){
            if(ingredientService.read(ingredient.getId()) == null){
                invalidIngredients.add(ingredient);
            }
        }
        if(invalidIngredients.isEmpty()){
            return menuItemService.save(obj);
        }
        return null;
    }

    /* -This method retrieves a list of MenuItem objects that use a specific Ingredient.


       -Retrieves the Ingredient using ingredientService.read(obj).
       -Finds all MenuItem instances that contain this ingredient using menuItemService.findAllByIngredientsIsContaining(i1).
       -If no MenuItem objects are found, it returns null.
       -Otherwise, it returns the list of MenuItem objects that contain the specified ingredient.

     */
    public List<MenuItem> itemsUsingIngredient(Long obj){
        Ingredient i1 = ingredientService.read(obj);
        List<MenuItem> menuItemList = menuItemService.findAllByIngredientsIsContaining(i1);
        if(menuItemList.isEmpty()){
            return null;
        }
        return menuItemList;
    }
}
