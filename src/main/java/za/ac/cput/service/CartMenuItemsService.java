package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.repository.CartMenuItemsRepo;
import za.ac.cput.service.interfaces.ICartMenuItemsService;

import java.util.List;

/**
 * Service implementation for CartMenuItems-related operations.
 */
@Service
public class CartMenuItemsService implements ICartMenuItemsService {
    private CartMenuItemsRepo cartMenuItemsRepo;

    /**
     * Constructor-based dependency injection of CartMenuItemsRepo.
     *
     * @param cartMenuItemsRepo the CartMenuItems repository instance
     */
    @Autowired
    public CartMenuItemsService(CartMenuItemsRepo cartMenuItemsRepo) {
        this.cartMenuItemsRepo = cartMenuItemsRepo;
    }

    /**
     * Saves a CartMenuItems object to the database.
     *
     * @param obj the CartMenuItems object to save
     * @return the saved CartMenuItems object
     */
    @Override
    public CartMenuItems save(CartMenuItems obj) {
        return cartMenuItemsRepo.save(obj);
    }

    /**
     * Reads a CartMenuItems object from the database by ID.
     *
     * @param s the ID of the CartMenuItems
     * @return the CartMenuItems object if found; otherwise, null
     */
    @Override
    public CartMenuItems read(Long s) {
        return cartMenuItemsRepo.findById(s).orElse(null);
    }

    /**
     * Updates an existing CartMenuItems object in the database.
     *
     * @param obj the CartMenuItems object to update
     * @return the updated CartMenuItems object if it exists; otherwise, null
     */
    @Override
    public CartMenuItems update(CartMenuItems obj) {
        if (cartMenuItemsRepo.existsById(obj.getId())) {
            return cartMenuItemsRepo.save(obj);
        }
        return null;
    }

    /**
     * Deletes a CartMenuItems object from the database by ID.
     *
     * @param s the ID of the CartMenuItems to delete
     * @return true if the CartMenuItems was deleted; otherwise, false
     */
    @Override
    public Boolean delete(Long s) {
        if (cartMenuItemsRepo.existsById(s)) {
            cartMenuItemsRepo.deleteById(s);
            return true;
        }
        return false;
    }

    /**
     * Retrieves all CartMenuItems objects from the database.
     *
     * @return a list of all CartMenuItems objects
     */
    @Override
    public List<CartMenuItems> getAll() {
        return cartMenuItemsRepo.findAll();
    }
}
