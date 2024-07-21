package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
}
