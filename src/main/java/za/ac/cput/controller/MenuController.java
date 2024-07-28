package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Menu;
import za.ac.cput.factory.MenuFactory;
import za.ac.cput.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/save")
    public ResponseEntity<Menu> save(@RequestBody Menu obj){
        Menu m1 = MenuFactory.buildMenu(obj.getName());
        if(m1 ==null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(menuService.save(m1));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Menu> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(menuService.read(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Menu> update(@RequestBody Menu obj){
        Menu m1 = MenuFactory.buildMenu(obj.getId(), obj.getName());
        if(m1 == null){
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(null);

        }
        return ResponseEntity.status(HttpStatus.OK).body(menuService.update(m1));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(menuService.delete(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Menu>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(menuService.getAll());
    }
}
