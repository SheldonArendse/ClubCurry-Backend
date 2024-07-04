package za.ac.cput.service.interfaces;

import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;

import java.util.List;

public interface IMenuItemService extends IService<MenuItem, Long>{
    public List<MenuItem> findAllByIngredientsIsContaining(Ingredient obj);

}
