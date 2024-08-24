package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;

import java.util.List;

public interface IMenuItemService extends IService<MenuItem, Long>{

    public List<MenuItem> findAllByIdIsIn(List<Long> items);
    public List<MenuItem> findAllByIngredientsIsContaining(Ingredient obj);

    public MenuItem findByDescriptionAndAndNameAndPrice(String description, String name, double price);

}
