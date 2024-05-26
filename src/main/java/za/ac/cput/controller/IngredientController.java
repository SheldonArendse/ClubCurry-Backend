package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.service.IngredientService;

import java.util.List;

@RestController
@RequestMapping("/Ingedient")
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/createOrUpdate")
    public Ingredient create(@RequestBody Ingredient obj) {
        return ingredientService.create(obj);
    }

    @GetMapping("/read/{id}")
    public Ingredient read(@PathVariable String s) {
        return ingredientService.read(s);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Ingredient obj) {
        ingredientService.delete(obj);
    }

    @GetMapping("/getall")
    public List<Ingredient> getAll() {
        return ingredientService.getAll();
    }
}
