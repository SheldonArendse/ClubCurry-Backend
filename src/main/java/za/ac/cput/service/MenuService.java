package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Menu;
import za.ac.cput.repository.MenuRepository;

import java.util.List;

@Service
public class MenuService implements IMenuService{

    private MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu create(Menu obj) {
        return menuRepository.save(obj);
    }

    @Override
    public Menu read(String s) {
        return menuRepository.findById(s).orElse(null);
    }

    @Override
    public void delete(Menu obj) {
        menuRepository.delete(obj);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }
}
