package za.ac.cput.factory;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VehicleFactory.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class IngredientFactoryTest {

    @Test
    @Order(1)
    void buildIngredient() {
        Ingredient ingredient = IngredientFactory.buildIngredient("Chicken");
        assertNotNull(ingredient);
        System.out.println(ingredient);
    }

    @Test
    @Order(2)
    void testBuildIngredientFail() {
        Ingredient ingredient = IngredientFactory.buildIngredient("");
        assertNotNull(ingredient);
        System.out.println(ingredient);
    }

    @Test
    @Order(3)
    void buildIngredientWithId() {
        Ingredient ingredient = IngredientFactory.buildIngredient(1234567, "Beef");
        assertNotNull(ingredient);
        System.out.println(ingredient);
    }

    @Test
    @Order(4)
    void buildIngredientWithIdFail(){
        Ingredient ingredient = IngredientFactory.buildIngredient(-122345666, "Beef");
        assertNotNull(ingredient);
        System.out.println(ingredient);
    }
}