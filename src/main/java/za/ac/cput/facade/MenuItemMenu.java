package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Menu;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.service.MenuItemService;
import za.ac.cput.service.MenuService;

@Component
public class MenuItemMenu {

    private MenuService menuService;
    private MenuItemService menuItemService;

    @Autowired
    public MenuItemMenu(MenuService menuService, MenuItemService menuItemService) {
        this.menuService = menuService;
        this.menuItemService = menuItemService;
    }

    public MenuItem canSave(MenuItem obj){
        Menu m1 = menuService.read(obj.getMenuId().getId());
        if(m1 == null){
            return null;
        }
        MenuItem m2 = new MenuItem.Builder().copy(obj).setMenuId(m1).build();
        return menuItemService.save(m2);
    }

    public MenuItem canUpdateMenu(MenuItem obj){
        System.out.println(obj);
        Menu m1 = menuService.read(obj.getMenuId().getId());
        System.out.println(m1);
        if(m1 == null){
            return null;
        }
        MenuItem m2 = new MenuItem.Builder().copy(obj).setMenuId(m1).build();
        return menuItemService.update(m2);
    }
    public boolean validMenu(MenuItem obj){
        Menu m1 = menuService.read(obj.getMenuId().getId());
        return m1 != null;
    }
}
