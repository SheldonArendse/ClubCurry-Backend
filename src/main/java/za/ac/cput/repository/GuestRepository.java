package za.ac.cput.repository;

/*
Customer.Java
Guest Repository
Author: Aa'ishah Van Witt
Date:  17 May 2024
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {
}
