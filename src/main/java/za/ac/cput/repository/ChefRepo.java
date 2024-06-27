package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Cart;

public interface ChefRepo extends JpaRepository<Cart, String> {
}
