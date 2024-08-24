package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.repository.MenuItemRepo;
import za.ac.cput.service.interfaces.IMenuItemService;

import java.util.List;

@Service
public class MenuItemService implements IMenuItemService {

    private MenuItemRepo menuItemRepo;

    @Autowired
    public MenuItemService(MenuItemRepo menuItemRepo) {
        this.menuItemRepo = menuItemRepo;
    }

    @Override
    public MenuItem save(MenuItem obj) {
        return menuItemRepo.save(obj);
    }

    @Transactional(readOnly = true)
    @Override
    public MenuItem read(Long aLong) {
        return menuItemRepo.findById(aLong).orElse(null);
    }

    @Override
    public MenuItem update(MenuItem obj) {
        if(menuItemRepo.existsById(obj.getId())){
            return menuItemRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(menuItemRepo.existsById(aLong)){
            menuItemRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<MenuItem> getAll() {
        return menuItemRepo.findAll();
    }

    @Override
    public List<MenuItem> findAllByIdIsIn(List<Long> items) {
        return menuItemRepo.findAllByIdIsIn(items);
    }

    @Override
    public List<MenuItem> findAllByIngredientsIsContaining(Ingredient obj) {
        return menuItemRepo.findAllByIngredientsIsContaining(obj);
    }

    @Override
    public MenuItem findByDescriptionAndAndNameAndPrice(String description, String name, double price) {
        return menuItemRepo.findByDescriptionAndAndNameAndPrice(description,name,price);
    }
}
