package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Supplier;

public interface SupplierRepo extends JpaRepository<Supplier, String> {
}
