package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Orders;

public interface OrderRepo extends JpaRepository<Orders, Long> {
}
