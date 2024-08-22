package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.facade.IngredientMenuItem;
import za.ac.cput.facade.MenuItemMenu;
import za.ac.cput.factory.MenuItemFactory;
import za.ac.cput.service.MenuItemService;

import java.util.List;

@RestController
@RequestMapping("/menuItem")
public class MenuItemController {

    private MenuItemService menuItemService;

    private MenuItemMenu menuItemMenu;

    private IngredientMenuItem ingredientMenuItem;

    @Autowired
    public MenuItemController(MenuItemService menuItemService, MenuItemMenu menuItemMenu, IngredientMenuItem ingredientMenuItem) {
        this.menuItemService = menuItemService;
        this.menuItemMenu = menuItemMenu;
        this.ingredientMenuItem = ingredientMenuItem;
    }



    @PostMapping("/save")
    public ResponseEntity<MenuItem> save(@RequestBody MenuItem obj){
        MenuItem builtObj = MenuItemFactory.buildMenuItem(obj.getDescription(), obj.getName(), obj.getPrice(), obj.getMenuId());
        if(builtObj == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        MenuItem m1 = menuItemMenu.canSave(builtObj);

        if(m1 == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<MenuItem> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(menuItemService.read(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(menuItemService.delete(id));
    }

    @PutMapping("/update")
    public ResponseEntity<MenuItem> update(@RequestBody MenuItem obj){
        MenuItem builtObj = MenuItemFactory.buildMenuItem(obj.getId(), obj.getName(), obj.getPrice(), obj.getMenuId());

        if(builtObj == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }

        MenuItem m1 = menuItemMenu.canUpdateMenu(builtObj);
        if(m1 == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(m1);
    }

    @PutMapping("/updateWithIngredients")
    public ResponseEntity<MenuItem> updateWithIngredients(@RequestBody MenuItem obj){
        MenuItem m1 = MenuItemFactory.buildMenuItem(obj.getId(), obj.getName(),obj.getPrice(), obj.getMenuId(), obj.getDescription(),obj.getIngredients());
        if(m1 == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        if(menuItemMenu.validMenu(obj)){
            return ResponseEntity.status(HttpStatus.OK).body(ingredientMenuItem.validIngredients(obj));
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<MenuItem>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(menuItemService.getAll());
    }

    @GetMapping("/getItemByDetails/{description}/{name}/{price}")
    public ResponseEntity<MenuItem> getItemByDetails(@PathVariable String description, @PathVariable String name, @PathVariable double price){
        MenuItem m1 = MenuItemFactory.buildMenuItem(description,name,price);
        if(m1 != null){
            MenuItem m2 = menuItemService.findByDescriptionAndAndNameAndPrice(m1.getDescription(), m1.getName(), m1.getPrice());
            if(m2 != null){
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(m2);
            }
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
    }

}
