package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.StockOrder;

public interface StockOrderRepo extends JpaRepository<StockOrder, Long> {
}
