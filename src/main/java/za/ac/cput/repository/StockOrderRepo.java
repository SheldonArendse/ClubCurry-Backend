package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.StockOrder;

@Repository
public interface StockOrderRepo extends JpaRepository<StockOrder, Long> {
}
