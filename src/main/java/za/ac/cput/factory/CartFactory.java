package za.ac.cput.factory;

import za.ac.cput.domain.Cart;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.CartMenuItems;

import java.util.List;

/**
 * Factory class for creating instances of Cart.
 * Provides methods to create Cart objects with different sets of data.
 */
public class CartFactory {

    /**
     * Creates a Cart object if the provided customer and menu items are valid.
     *
     * @param customer  the Customer associated with the Cart
     * @param menuItems the list of CartMenuItems in the Cart
     * @return a new Cart object if the data is valid; otherwise, returns null
     */
    public static Cart buildCart(Customer customer, List<CartMenuItems> menuItems) {
        // Validate that customer is not null and menuItems list is not empty
        if (customer != null && !menuItems.isEmpty()) {
            return new Cart.Builder().setCustomer(customer).setItems(menuItems).build();
        }
        return null;
    }

    /**
     * Creates a Cart object with an ID if the provided data is valid.
     *
     * @param id        the ID of the Cart
     * @param customer  the Customer associated with the Cart
     * @param menuItems the list of CartMenuItems in the Cart
     * @return a new Cart object if the data is valid; otherwise, returns null
     */
    public static Cart buildCart(Long id, Customer customer, List<CartMenuItems> menuItems) {
        // Validate that customer is not null, menuItems list is not empty, and ID is non-negative
        if (customer != null && !menuItems.isEmpty() && id >= 0) {
            return new Cart.Builder().setId(id).setCustomer(customer).setItems(menuItems).build();
        }
        return null;
    }

    /**
     * Creates a Cart object with only a customer if the customer is valid.
     *
     * @param customer the Customer associated with the Cart
     * @return a new Cart object if the customer is valid; otherwise, returns null
     */
    public static Cart buildCart(Customer customer) {
        // Validate that customer is not null
        if (customer != null) {
            return new Cart.Builder().setCustomer(customer).build();
        }
        return null;
    }
}
