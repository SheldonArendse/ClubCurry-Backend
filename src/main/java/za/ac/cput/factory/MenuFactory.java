package za.ac.cput.factory;

import za.ac.cput.domain.Menu;
import za.ac.cput.util.Helper;

public class MenuFactory {

    public static Menu buildMenu(String menuId, String menuName, String SpiceLevel){
        if(Helper.isNullOrEmpty(menuId) || Helper.isNullOrEmpty(menuName)|| Helper.isNullOrEmpty(SpiceLevel)){
            return null;
        }
        return new Menu.Builder().setMenuId(menuId).setMenuName(menuName).setSpiceLevel(SpiceLevel).build();
    }
    public static Menu buildMenu(String menuName, String SpiceLevel){
        if(Helper.isNullOrEmpty(menuName)|| Helper.isNullOrEmpty(SpiceLevel)){
            return null;
        }
        return new Menu.Builder().setMenuName(menuName).setSpiceLevel(SpiceLevel).build();
    }
}
