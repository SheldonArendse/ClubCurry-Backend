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

    public List<MenuItem> itemsUsingIngredient(Long obj){
        Ingredient i1 = ingredientService.read(obj);
        List<MenuItem> menuItemList = menuItemService.findAllByIngredientsIsContaining(i1);
        if(menuItemList.isEmpty()){
            return null;
        }
        return menuItemList;
    }
}
