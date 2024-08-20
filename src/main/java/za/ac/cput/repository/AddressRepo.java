package za.ac.cput.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
