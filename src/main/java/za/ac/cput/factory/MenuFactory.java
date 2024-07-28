package za.ac.cput.factory;

import za.ac.cput.domain.Menu;
import za.ac.cput.domain.enums.SpiceLevel;
import za.ac.cput.utils.Validation;

public class MenuFactory {

    public static Menu buildMenu(String name){
        if(Validation.isValidString(name)){
            return new Menu.Builder().setName(name).build();
        }
        return null;
    }
    public static Menu buildMenu(Long id, String name){
        if(Validation.isValidString(name)){
            return new Menu.Builder().setName(name).setId(id).build();
        }
        return null;
    }
}
