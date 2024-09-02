package za.ac.cput.factory;

import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

/**
 * Factory class for creating instances of CartMenuItems.
 * Provides methods to create CartMenuItems objects with different sets of data.
 */
public class CartMenuItemsFactory {

    /**
     * Creates a CartMenuItems object if the provided data is valid.
     *
     * @param menuItem   the MenuItem associated with the CartMenuItems
     * @param quantity   the quantity of the MenuItem in the CartMenuItems
     * @param note       any notes associated with the MenuItem
     * @param spiceLevel the spice level of the MenuItem
     * @return a new CartMenuItems object if the data is valid; otherwise, returns null
     */
    public static CartMenuItems buildCartMenuItem(MenuItem menuItem, int quantity, String note, SpiceLevel spiceLevel) {
        // Validate that MenuItem ID is positive, quantity is positive, note is not empty, and spice level is not null
        if (menuItem.getId() > 0 && quantity > 0 && !note.isEmpty() && spiceLevel != null) {
            return new CartMenuItems.Builder().setMenuItem(menuItem).setQuantity(quantity).setSpiceLevel(spiceLevel).setNote(note).build();
        }
        return null;
    }

    /**
     * Creates a CartMenuItems object with an ID if the provided data is valid.
     *
     * @param id         the ID of the CartMenuItems
     * @param menuItem   the MenuItem associated with the CartMenuItems
     * @param quantity   the quantity of the MenuItem in the CartMenuItems
     * @param note       any notes associated with the MenuItem
     * @param spiceLevel the spice level of the MenuItem
     * @return a new CartMenuItems object if the data is valid; otherwise, returns null
     */
    public static CartMenuItems buildCartMenuItem(Long id, MenuItem menuItem, int quantity, String note, SpiceLevel spiceLevel) {
        // Validate that MenuItem ID is positive, quantity is positive, note is not empty, and spice level is not null
        if (menuItem.getId() > 0 && quantity > 0 && !note.isEmpty() && spiceLevel != null) {
            return new CartMenuItems.Builder().setMenuItem(menuItem).setQuantity(quantity).setSpiceLevel(spiceLevel).setNote(note).setId(id).build();
        }
        return null;
    }
}
