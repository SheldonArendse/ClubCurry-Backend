package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;
import za.ac.cput.facade.IngredientMenuItem;
import za.ac.cput.factory.IngredientFactory;
import za.ac.cput.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    private IngredientService ingredientService;
    private IngredientMenuItem ingredientMenuItem;

    @Autowired
    public IngredientController(IngredientService ingredientService, IngredientMenuItem ingredientMenuItem) {
        this.ingredientService = ingredientService;
        this.ingredientMenuItem = ingredientMenuItem;
    }

    @PostMapping("/save")
    public ResponseEntity<Ingredient> save(@RequestBody Ingredient obj){
        Ingredient i1 = IngredientFactory.buildIngredient(obj.getName());
        if(i1 == null){
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.save(i1));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Ingredient> read(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(ingredientService.read(id));
    }
}
