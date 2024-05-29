package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Ingredient;

import static org.junit.jupiter.api.Assertions.*;

class IngredientFactoryTest {

    @Test
    void buildIngredient() {
        Ingredient i1 = IngredientFactory.buildIngredient("Carrots",20);
        assertNotNull(i1);
    }

    @Test
    void testBuildIngredient() {
        Ingredient i1 = IngredientFactory.buildIngredient("",20);
        assertNull(i1);
    }
}