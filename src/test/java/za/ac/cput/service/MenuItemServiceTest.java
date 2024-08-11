package za.ac.cput.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;
import za.ac.cput.factory.MenuItemFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class MenuItemServiceTest {

  /*  @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private IngredientService ingredientService;

    private Menu menu;

    private MenuItem menuItem;
    private Ingredient ingredient;

    @Test
    void a_save() {
        Menu menu = new Menu.Builder().setName("Seafood Curry").build();
        menu = menuService.save(menu);

        ingredient = new Ingredient.Builder()
                .setName("Crabsticks")
                .build();
        ingredient = ingredientService.save(ingredient);

        List<Ingredient> ingredients = Arrays.asList(ingredient);

        int quantity = 1;
        SpiceLevel spiceLevel = SpiceLevel.MED;
        String note = "Add a slight kick, not too hot";

        menuItem = MenuItemFactory.buildMenuItem(29L, "Crabsticks", 45.00, menu, ingredients, quantity, spiceLevel, note);

        MenuItem savedMenuItem = menuItemService.save(menuItem);
        assertNotNull(savedMenuItem);
        System.out.println(savedMenuItem);
    }

    @Test
    void b_read() {
        MenuItem read = menuItemService.read(29L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        MenuItem newMenuItem = new MenuItem.Builder().copy(menuItem).setName("fish chunks").build();
        MenuItem updated = menuItemService.update(newMenuItem);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    @Disabled
    void g_delete() {
        menuItemService.delete(menuItem.getId());
        System.out.println("MenuItem successfully deleted");
    }

    @Test
    void f_getAll() {
        System.out.println(menuItemService.getAll());
    }

    @Test
    void d_findAllByIdIsIn() {
        List<Long> ids = List.of(menuItem.getId());
        List<MenuItem> foundMenuItems = menuItemService.findAllByIdIsIn(ids);
        assertNotNull(foundMenuItems);
        System.out.println(foundMenuItems);
    }

    @Test
    void e_findAllByIngredientsIsContaining() {
        List<MenuItem> foundMenuItems = menuItemService.findAllByIngredientsIsContaining(ingredient);
        assertNotNull(foundMenuItems);
        System.out.println(foundMenuItems);
    } */
}