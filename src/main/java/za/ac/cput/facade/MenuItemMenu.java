package za.ac.cput.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
        if(menuService.read(obj.getMenuId().getId()) == null){
            return null;
        }
        return menuItemService.save(obj);
    }

    public MenuItem canUpdateMenu(MenuItem obj){
        if(menuService.read(obj.getMenuId().getId()) == null){
            return null;
        }
        return menuItemService.update(obj);
    }
}
