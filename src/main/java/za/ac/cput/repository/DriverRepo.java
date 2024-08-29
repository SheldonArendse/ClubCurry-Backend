package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, String>{

    public Driver findByUsername(String username);
}
