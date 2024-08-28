package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemFactoryTest {

    @Test
    void buildMenuItem() {
        MenuItem obj = MenuItemFactory.buildMenuItem("test","Name",25.25, new Menu.Builder().setName("Menu").build());
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildMenuItem() {
        MenuItem obj = MenuItemFactory.buildMenuItem(3L,"test","Name",25.25, new Menu.Builder().setName("Menu").build());
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildMenuItem1() {
        MenuItem obj = MenuItemFactory.buildMenuItem(1L);
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildMenuItem2() {
        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient.Builder().setName("chicken").build());
        MenuItem obj = MenuItemFactory.buildMenuItem(3L,"test", 5205,new Menu.Builder().setName("Menu").build(),"testing",ingredientList);
        assertNotNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildMenuItemFail() {
        MenuItem obj = MenuItemFactory.buildMenuItem("","",25.25, new Menu.Builder().setName("Menu").build());
        assertNull(obj);
        System.out.println(obj);
    }

    @Test
    void testBuildMenuItemFail1() {
        List<Ingredient> ingredientList = null;
        MenuItem obj = MenuItemFactory.buildMenuItem(-5L,"test", 5205,new Menu.Builder().setName("Menu").build(),"testing",ingredientList);
        assertNull(obj);
        System.out.println(obj);
    }
}