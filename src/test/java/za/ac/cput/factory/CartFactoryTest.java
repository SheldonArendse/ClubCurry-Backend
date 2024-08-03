package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.domain.Customer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class CartFactoryTest {

        @Test
        void testBuildCartWithCustomerAndMenuItems_Passing() {
            Customer customer = CustomerFactory.buildCustomer("mohs@gmail.com","Mo", "Zouheir", "0625460987", "Kl$dfmnjsjeS12"); // Assume this object is properly instantiated
            List<CartMenuItems> menuItems = new ArrayList<>();
            menuItems.add(mock(CartMenuItems.class));
            Cart cart = CartFactory.buildCart(customer, menuItems);
            assertNotNull(cart);
            assertEquals(customer, cart.getCustomer());
            assertEquals(menuItems, cart.getItems());
        }

        @Test
        void testBuildCartWithCustomerAndMenuItems_Failing() {
            Customer customer = null;
            List<CartMenuItems> menuItems = new ArrayList<>();
            menuItems.add(mock(CartMenuItems.class));
            Cart cart = CartFactory.buildCart(customer, menuItems);
            assertNull(cart);
        }



}