package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {
}
