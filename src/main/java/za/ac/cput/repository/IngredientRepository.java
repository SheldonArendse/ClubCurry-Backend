package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}
