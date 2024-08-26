package za.ac.cput.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.factory.IngredientFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

class IngredientServiceTest {

    @Autowired
    private IngredientService ingredientService;

    Ingredient ingredient1, ingredient2;

    @BeforeEach
    void a_setup(){
        ingredient1 = IngredientFactory.buildIngredient(2345678, "Chicken");
        assertNotNull(ingredient1);
        System.out.println(ingredient1);

        ingredient2 = IngredientFactory.buildIngredient(1234567, "Prawns");
        assertNotNull(ingredient2);
        System.out.println(ingredient2);
    }

    @Test
    void b_save() {
        Ingredient savedIngredient1 = ingredientService.save(ingredient1);
        assertNotNull(savedIngredient1);
        System.out.println(savedIngredient1);

        Ingredient savedIngredient2 = ingredientService.save(ingredient2);
        assertNotNull(savedIngredient2);
        System.out.println(savedIngredient2);
    }

    @Test
    void c_read() {
        Ingredient read = ingredientService.read(1L);
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void d_update() {
        Ingredient newIngredient = new Ingredient.Builder().copy(ingredient1).setName("Beef").setId(1L).build();
        Ingredient updated = ingredientService.update(newIngredient);
        assertNotNull(updated);
        System.out.println(updated);
    }

    @Test
    void f_delete() {
        ingredientService.delete(ingredient2.getId());
        System.out.println("ingredient2 successfully deleted");
    }

    @Test
    void e_getAll() {
        System.out.println(ingredientService.getAll());
    }
}