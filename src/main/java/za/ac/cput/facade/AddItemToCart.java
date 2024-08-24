package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Cart;
import za.ac.cput.domain.CartMenuItems;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.service.CartMenuItemsService;
import za.ac.cput.service.CartService;
import za.ac.cput.service.MenuItemService;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddItemToCart {
    private MenuItemService menuItemService;
    private CartMenuItemsService cartMenuItemsService;

    @Autowired
    public AddItemToCart(MenuItemService menuItemService, CartMenuItemsService cartMenuItemsService) {
        this.menuItemService = menuItemService;
        this.cartMenuItemsService = cartMenuItemsService;
    }

    public Cart validItems(Cart obj){
        List<CartMenuItems> items = obj.getItems();
        List<Long> menuItems = new ArrayList<>();
        for(CartMenuItems item: items){
            menuItems.add(item.getMenuItem().getId());
        }
        List<MenuItem> dbReturn = menuItemService.findAllByIdIsIn(menuItems);
        if(dbReturn.isEmpty()){
            return null;
        }
        for(CartMenuItems cartItems: items){
            cartMenuItemsService.save(cartItems);
        }
        return obj;
    }
}
