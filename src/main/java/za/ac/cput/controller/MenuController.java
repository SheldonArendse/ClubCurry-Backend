package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Menu;
import za.ac.cput.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/Menu")
public class MenuController {
    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/createOrUpdate")
    public Menu create(@RequestBody Menu obj) {
        return menuService.create(obj);
    }

    @GetMapping("/read/{id}")
    public Menu read(@PathVariable String s) {
        return menuService.read(s);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Menu obj) {
        menuService.delete(obj);
    }

    @GetMapping("/getall")
    public List<Menu> getAll() {
        return menuService.getAll();
    }
}
