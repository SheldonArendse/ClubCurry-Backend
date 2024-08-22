package za.ac.cput.service;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.repository.IngredientRepo;
import za.ac.cput.service.interfaces.IIngredientService;

import java.util.List;

@Service
public class IngredientService implements IIngredientService {

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

    @Override
    public Ingredient update(Ingredient obj) {
        if(ingredientRepo.existsById(obj.getId())){
            return ingredientRepo.save(obj);
        }
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        if(ingredientRepo.existsById(aLong)){
            ingredientRepo.deleteById(aLong);
            return true;
        }
        return null;
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepo.findAll();
    }
}
