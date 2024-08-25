package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.repository.IngredientRepo;
import za.ac.cput.service.interfaces.IIngredientService;
import za.ac.cput.service.interfaces.IService;

import java.util.List;

@Service
public class IngredientService implements IIngredientService{

    private IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @Override
    public Ingredient save(Ingredient obj) {
        return ingredientRepo.save(obj);
    }

    @Override
    public Ingredient read(Long aLong) {
        return ingredientRepo.findById(aLong).orElse(null);
    }

}
