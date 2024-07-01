package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.MenuItem;

@Repository
public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
}
