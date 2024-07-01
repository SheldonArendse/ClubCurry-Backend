package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import za.ac.cput.domain.enums.SpiceLevel;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CartFactoryTest {

    @Test
    void buildCart() {
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18@gmail.com", "Logan", "Coghill","0875632598","Th#s1sATest");
        Menu m1 = MenuFactory.buildMenu("curries", SpiceLevel.MED);

        Ingredient i1 = IngredientFactory.buildIngredient("Rice", 100);
        Ingredient i2 = IngredientFactory.buildIngredient("Chicken", 100);
        Ingredient i3 = IngredientFactory.buildIngredient("Potatoes", 100);
        List<Ingredient> listI = new ArrayList<>();
        listI.add(i1);
        listI.add(i2);
        listI.add(i3);

        MenuItem mi1 = MenuItemFactory.buildMenuItem("curry", 100, m1,listI);

        List<MenuItem> listM = new ArrayList<>();
        listM.add(mi1);

        Cart cart1 = CartFactory.buildCart(c1,listM);

        assertNotNull(cart1);

        System.out.println(cart1);

    }

    @Test
    void buildCartWithId() {
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18@gmail.com", "Logan", "Coghill","0875632598","Th#s1sATest");
        Menu m1 = MenuFactory.buildMenu("curries", SpiceLevel.MED);

        Ingredient i1 = IngredientFactory.buildIngredient("Rice", 100);
        Ingredient i2 = IngredientFactory.buildIngredient("Chicken", 100);
        Ingredient i3 = IngredientFactory.buildIngredient("Potatoes", 100);
        List<Ingredient> listI = new ArrayList<>();
        listI.add(i1);
        listI.add(i2);
        listI.add(i3);

        MenuItem mi1 = MenuItemFactory.buildMenuItem("curry", 100, m1,listI);

        List<MenuItem> listM = new ArrayList<>();
        listM.add(mi1);

        Cart cart1 = CartFactory.buildCart(7L,c1,listM);

        assertNotNull(cart1);

        System.out.println(cart1);
    }

    @Test
    void buildCartFail(){
        Customer c1 = CustomerFactory.buildCustomer("logancoghill18@gmail.com", "Logan", "Coghill","0875632598","Th#s1sATest");

        List<MenuItem> listM = new ArrayList<>();

        Cart cart1 = CartFactory.buildCart(7L,c1,listM);

        assertNull(cart1);
    }
}