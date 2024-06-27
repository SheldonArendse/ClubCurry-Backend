package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Menu;

public interface MenuRepo extends JpaRepository<Menu, Long> {
}
