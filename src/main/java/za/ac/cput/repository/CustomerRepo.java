package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, String> {

    public Customer findCustomerByEmailAndPassword(String email, String password);
}
