package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Chef;

@Repository
public interface ChefRepo extends JpaRepository<Chef, String> {
}
