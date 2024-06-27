package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Ingredient;

public interface IngredientRepo extends JpaRepository<Ingredient, String> {
}
