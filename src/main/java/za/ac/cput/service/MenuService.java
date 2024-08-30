package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Menu;
import za.ac.cput.repository.MenuRepo;
import za.ac.cput.service.interfaces.IMenuService;

import java.util.List;

@Service
public class MenuService implements IMenuService {

    private MenuRepo menuRepo;

    @Autowired
    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }

    @Override
    public Menu save(Menu obj) {
        return menuRepo.save(obj);
    }

    @Override
    public Menu read(Long aLong) {
        return menuRepo.findById(aLong).orElse(null);
    }

    @Override
    public Menu update(Menu obj) {
        if(menuRepo.existsById(obj.getId())){
            return menuRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(menuRepo.existsById(aLong)){
            menuRepo.deleteById(aLong);
            return true;
        }
        return false;
    }

    @Override
    public List<Menu> getAll() {
        return menuRepo.findAll();
    }

    @Override
    public Menu findByName(String name) {
        return menuRepo.findByName(name);
    }
}
