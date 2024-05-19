package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.repository.IngredientRepository;

import java.util.List;
@Service
public class IngredientService implements IIngredientService{

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient create(Ingredient obj) {
        return ingredientRepository.save(obj);
    }

    @Override
    public Ingredient read(String s) {
        return ingredientRepository.findById(s).orElse(null);
    }

    @Override
    public void delete(Ingredient obj) {
        ingredientRepository.delete(obj);
    }

    @Override
    public List<Ingredient> getAll() {
        return ingredientRepository.findAll();
    }
}
