package za.ac.cput.repository;

/*
Customer.Java
Address Repository
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
