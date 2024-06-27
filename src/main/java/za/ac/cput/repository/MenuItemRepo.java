package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.MenuItem;

public interface MenuItemRepo extends JpaRepository<MenuItem, Long> {
}
