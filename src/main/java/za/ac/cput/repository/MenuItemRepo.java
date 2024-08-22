package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Ingredient;
import za.ac.cput.domain.MenuItem;

import java.util.Collection;
import java.util.List;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {

    public List<MenuItem> findAllByIdIsIn(Collection<Long> id);
    public List<MenuItem> findAllByIngredientsIsContaining(Ingredient obj);

    public MenuItem findByDescriptionAndAndNameAndPrice(String description, String name, double price);
}
