package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.service.CartMenuItemsService;
import za.ac.cput.service.MenuItemService;

import java.util.ArrayList;
import java.util.List;

/**
 * Facade class that provides functionality to add items to a cart.
 */
@Component
public class AddItemToCart {

    private MenuItemService menuItemService;
    private CartMenuItemsService cartMenuItemsService;

    /**
     * Constructor for dependency injection.
     *
     * @param menuItemService      the MenuItem service
     * @param cartMenuItemsService the CartMenuItems service
     */
    @Autowired
    public AddItemToCart(MenuItemService menuItemService, CartMenuItemsService cartMenuItemsService) {
        this.menuItemService = menuItemService;
        this.cartMenuItemsService = cartMenuItemsService;
    }

    /**
     * Validates the items being added to a cart and saves them if valid.
     *
     * @param obj the Cart object containing items to be validated and added
     * @return the Cart object with valid items, or null if validation fails
     */
    public Cart validItems(Cart obj) {
        // Extract list of CartMenuItems from the Cart object
        List<CartMenuItems> items = obj.getItems();
        // Create a list to hold the IDs of MenuItems
        List<Long> menuItems = new ArrayList<>();

        // Loop through each CartMenuItem and add the MenuItem ID to the list
        for (CartMenuItems item : items) {
            menuItems.add(item.getMenuItem().getId());
        }

        // Fetch all MenuItems that match the list of IDs
        List<MenuItem> dbReturn = menuItemService.findAllByIdIsIn(menuItems);

        // If no matching MenuItems are found in the database, return null
        if (dbReturn.isEmpty()) {
            return null;
        }

        // Save each valid CartMenuItem to the database
        for (CartMenuItems cartItems : items) {
            cartMenuItemsService.save(cartItems);
        }

        // Return the Cart object with the valid items
        return obj;
    }
}
