package za.ac.cput.factory;

import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.domain.enums.SpiceLevel;

public class CartMenuItemsFactory {

    public static CartMenuItems buildCartMenuItem(MenuItem menuItem, int quantity, String note, SpiceLevel spiceLevel){
        if(menuItem.getId() >0 && quantity >0 && !note.isEmpty() && spiceLevel !=null){
            return new CartMenuItems.Builder().setMenuItem(menuItem).setQuantity(quantity).setSpiceLevel(spiceLevel).setNote(note).build();
        }
        return null;
    }

    public static CartMenuItems buildCartMenuItem(Long id, MenuItem menuItem, int quantity, String note, SpiceLevel spiceLevel){
        if(menuItem.getId() >0 && quantity >0 && !note.isEmpty() && spiceLevel !=null){
            return new CartMenuItems.Builder().setMenuItem(menuItem).setQuantity(quantity).setSpiceLevel(spiceLevel).setNote(note).setId(id).build();
        }
        return null;
    }
}
