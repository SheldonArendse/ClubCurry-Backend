package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class MenuItemFactoryTest {

    @Test
    @Order(1)
    void buildMenuItemWithId() {
       Menu menu = new Menu.Builder()
               .setName("Steak Curry")
               .build();

       MenuItem menuItem = MenuItemFactory.buildMenuItem(1234567L, "Steak", 25.00, menu);
       assertNotNull(menuItem);
        System.out.println(menuItem);

    }

    @Test
    @Order(2)
    void testBuildMenuItemWithIdFail() {
        Menu menu = new Menu.Builder()
                .setName("Steak Curry")
                .build();

        MenuItem menuItem = MenuItemFactory.buildMenuItem(-1234567L, "Steak", 25.00, menu);
        assertNotNull(menuItem);
        System.out.println(menuItem);
    }

    @Test
    @Order(3)
    void buildMenuItem() {
        Menu menu = new Menu.Builder()
                .setName("Beans Curry")
                .build();

        MenuItem menuItem = MenuItemFactory.buildMenuItem("Beans", 15.00, menu);
        assertNotNull(menuItem);
        System.out.println(menuItem);

    }

    @Test
    @Order(4)
    void testBuildMenuItemFail() {
        Menu menu = new Menu.Builder()
                .setName("Beans Curry")
                .build();

        MenuItem menuItem = MenuItemFactory.buildMenuItem("", 15.00, menu);
        assertNotNull(menuItem);
        System.out.println(menuItem);
    }

    @Test
    @Order(5)
    void buildMenuItemWithIngredients(){
        Menu menu = new Menu.Builder()
                .setName("Seafood Curry")
                .build();

        Ingredient ingredient1 = new Ingredient.Builder()
                .setName("Prawns")
                .build();

        Ingredient ingredient2 = new Ingredient.Builder()
                .setName("Crayfish")
                .build();

        Ingredient ingredient3 = new Ingredient.Builder()
                .setName("Crabsticks")
                .build();

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2, ingredient3);

        MenuItem menuItem = MenuItemFactory.buildMenuItem(12345678L, "seafood", 50.00, menu, ingredients);
        assertNotNull(menuItem);
        System.out.println(menuItem);

    }

    @Test
    @Order(6)
    void testBuildMenuItemWithIngredientsFail(){
        Menu menu = new Menu.Builder()
                .setName("Seafood Curry")
                .build();

        Ingredient ingredient1 = new Ingredient.Builder()
                .setName("Prawns")
                .build();

        Ingredient ingredient2 = new Ingredient.Builder()
                .setName("Crayfish")
                .build();

        Ingredient ingredient3 = new Ingredient.Builder()
                .setName("Crabsticks")
                .build();

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2, ingredient3);

        MenuItem menuItem = MenuItemFactory.buildMenuItem(-12345678L, "seafood", 50.00, menu, ingredients);
        assertNotNull(menuItem);
        System.out.println(menuItem);
    }

    @Test
    @Order(7)
    void buildFullMenuItem(){
        Menu menu = new Menu.Builder()
                .setName("Beef Curry")
                .build();

        Ingredient ingredient1 = new Ingredient.Builder()
                .setName("Potatoes")
                .build();

        Ingredient ingredient2 = new Ingredient.Builder()
                .setName("Beef")
                .build();

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        int quantity = 1;
        SpiceLevel spiceLevel = SpiceLevel.MED;
        String note = "Add a slight kick, not too hot";

        MenuItem menuItem = MenuItemFactory.buildMenuItem(2342564L, "Beef", 45.00, menu, ingredients, quantity, spiceLevel, note);
        assertNotNull(menuItem);
        System.out.println(menuItem);
    }

    @Test
    @Order(8)
    void buildFullMenuItemFail(){
        Menu menu = new Menu.Builder()
                .setName("Beef Curry")
                .build();

        Ingredient ingredient1 = new Ingredient.Builder()
                .setName("Potatoes")
                .build();

        Ingredient ingredient2 = new Ingredient.Builder()
                .setName("Beef")
                .build();

        List<Ingredient> ingredients = Arrays.asList(ingredient1, ingredient2);

        int quantity = 0;
        SpiceLevel spiceLevel = SpiceLevel.MED;
        String note = "Add a slight kick, not too hot";

        MenuItem menuItem = MenuItemFactory.buildMenuItem(2342564L, "Beef", 45.00, menu, ingredients, quantity, spiceLevel, note);
        assertNotNull(menuItem);
        System.out.println(menuItem);
    }
}